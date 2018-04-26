package singleton;

public class SingletonMain {
	public static void main(final String[] args) {
		try {
			// Do not do that IRL (this code is not safe), this may cause an exception.
			// The goal is to raise an exception.
			args[1].charAt(0);
		}catch(final ArrayIndexOutOfBoundsException ex) {
			MyExceptionCollector.INSTANCE.add(ex);
		}

		// Printing the collected exceptions.
		MyExceptionCollector.INSTANCE.forEach(System.out::println);
	}
}
