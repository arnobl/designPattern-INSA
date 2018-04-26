package singleton;

import java.util.ArrayList;

// An example of a singleton in Java.
// This code is quite awful since Java does not support Singleton natively.
// Look at the Scala code to see how Singleton can be natively supported


// The class must be final not to inherit of it.
public final class MyExceptionCollector extends ArrayList<Exception> {
	// The single instance of this class. Must be final and static.
	public static final MyExceptionCollector INSTANCE = new MyExceptionCollector();

	// A private constructor to forbid the instantiation of the class outside it.
	private MyExceptionCollector() {
		super();
	}
}
