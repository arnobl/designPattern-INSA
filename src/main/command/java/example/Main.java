package example;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		final Invoker invoker = new Invoker();
		final Editor editor = new EditorImpl();
		final List<String> myList = Arrays.asList("Foo", "Bar");

		// Java 7 version: using an anonymous class. Too much verbose
		invoker.addCommand(new Runnable() {
			@Override
			public void run() {
				editor.open();
			}
		});
		// Java 8 brings lambdas (anonymous operations)
		invoker.addCommand(() -> editor.open());
		// Idem than before but more concise (method reference)
		invoker.addCommand(editor::open);

		// The normal syntax of the forEach lambda
		myList.forEach((String elt) -> {
			System.out.println(elt);
		});
		// Sugar syntax to shorten the lambda
		myList.forEach(elt -> System.out.println(elt));
		// Another sugar syntax (method reference)
		myList.forEach(System.out::println);

		invoker.run();
	}
}
