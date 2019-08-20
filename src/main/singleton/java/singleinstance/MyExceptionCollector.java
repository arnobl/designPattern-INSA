package singleinstance;

import java.util.ArrayList;

// An example of the single instance pattern in Java.
// The motto: 'instance' is a pointer to one object, that can vary.
// This implementation still suffers from testability issues:
// static object may require to be reinit manually if stateful
// but mocking is easy here thanks to the setter.
public class MyExceptionCollector extends ArrayList<Exception> {
	// The single object. Not final as one can change it, but private
	private static MyExceptionCollector instance = new MyExceptionCollector();

	// The getter to access the single object
	public static MyExceptionCollector getInstance() {
		return instance;
	}

	// The setter for changing the single object
	public static void setInstance(final MyExceptionCollector instance) {
		if(instance != null) {
			MyExceptionCollector.instance = instance;
		}
	}

	// No constraint for defining a private constructor. The idea
	// is to have a pointer to a single object, not constraining
	// the instantiation of this object in the whole program.
	public MyExceptionCollector() {
		super();
	}
}
