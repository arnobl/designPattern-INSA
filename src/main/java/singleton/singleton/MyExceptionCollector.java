package singleton.singleton;

import java.util.ArrayList;

public final class MyExceptionCollector extends ArrayList<Exception> {
	public static final MyExceptionCollector instance = new MyExceptionCollector();

	private MyExceptionCollector() {
		super();
	}
}

class Main {
	void main() {
		MyExceptionCollector.instance.add(new NullPointerException());
//		new MyExceptionCollector(); // Not possible
	}
}
