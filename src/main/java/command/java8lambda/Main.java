package command.java8lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
	public static void main(final String[] args) {
		final Main main = new Main();
		main.lambdaFormats();
		main.variousFunctionalInterfaces();
	}

	void lambdaFormats() {
		// For Java 7 and lower. Verbose. Anonymous class.
		final List<Runnable> cmds = new ArrayList<>();

		Runnable cmd = new Runnable() {
			@Override
			public void run() {
				System.out.printf("%s%n", this);
			}
		};
		cmds.add(cmd);

		// Java 8 lambda: "()" is the parameter definition of the lambda. Nothing here since the single methods of Runnable ("run") does not take
		// any argument.
		// The body of the methods "run" is then defined. Do not forget the arrow ->
		cmd = () -> {
			System.out.printf("%s%n", this);
		};
		cmds.add(cmd);

		// Brackets are useless if the lambda contains a single instruction.
		cmd = () -> System.out.printf("%s%n", this);
		cmds.add(cmd);

		cmds.forEach(command -> {
			System.out.printf("Executing the command: %s%n\t", command);
			command.run();
		});
	}


	void variousFunctionalInterfaces() {
		// Look at Function, Runnable, etc. They are tagged as functional interfaces: they have a single abstract method that will be considered
		// as the command method.
		// These interfaces are mainly defined in the package java.util.function

		// An interface for producing values.
		Supplier<String> supplier = () -> "Hello world!";
		System.out.printf("%s, %s", supplier.get(), supplier.get());

		// A command to convert integer values as string values
		Function<Integer, String> fct = i -> String.valueOf(i); // This lambda corresponds to the definition of the method "R apply(T t)" defined in Function
		System.out.println(fct.apply(0));

		// There exists various interfaces specifically designed to handle primitive types
		IntFunction<String> intfct = i -> String.valueOf(i);
		System.out.println(intfct.apply(0));

		// A command that sums two given integer values.
		BiFunction<Integer, Integer, Integer> bifct = (i, j) -> i + j;
		System.out.println(bifct.apply(1, 2));
		System.out.println(bifct.apply(1, 4));

		// Uses an object to do something.
		Consumer<String> cons = str -> System.out.println(str);
		cons.accept("foo bar");
		cons.accept("test");

		Predicate<String> empty = str -> str.isEmpty();
		Predicate<Object> isnull = obj -> obj == null;
		System.out.printf("is '' empty? %b%n", empty.test(""));
		System.out.printf("is 'test' empty? %b%n", empty.test("test"));
		System.out.printf("is 'Foo' empty and null? %b%n", empty.and(isnull).test("Foo"));
	}
}
