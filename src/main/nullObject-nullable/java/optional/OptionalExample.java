package optional;

import java.util.Optional;

public class OptionalExample {
	public static void main(final String[] args) {
		// An optional object that contains nothing.
		Optional<String> foo = Optional.empty();

		// Creates an optional from a non null value
		foo = Optional.of("foo");

		// Creates an optional from a value that can be null.
		// If null, Optional.empty() is used
		foo = Optional.ofNullable(foo.toString());

		// isPresent checks the presence of an object in the optional one.
		System.out.println(foo.isPresent());

		// Verbose way
		if(foo.isPresent()) {
			// Never call get() without a isPresent() before
			final String s = foo.get();
			System.out.println(s);
		}
		
		// Concise way with ifPresent
		foo.ifPresent(s -> System.out.println(s));

		// Can transform optionals in other optionals using map
		final Optional<String> bar = foo.map(s -> s.toUpperCase());

		// If does not contain a value, the default value given as argument is returned
		final String def = foo.orElse("defaultValue");

		// If does not contain a value, the command given as argument is executed to return a default value
		foo.orElseGet(() -> "defaultValue");

		// If does not contain a value, the command given as argument is executed to raise an exception
		foo.orElseThrow(() -> new IllegalArgumentException());
	}
}
