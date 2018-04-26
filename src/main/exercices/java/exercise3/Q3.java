package exercise3;

import java.util.Random;
import java.util.stream.IntStream;

interface Object {
	void method();
}

class ObjectImpl1 implements Object {
	@Override
	public void method() {
		//...
		System.out.println("yop");
	}
}

class ObjectImpl2 implements Object {
	final Object obj = new ObjectImpl1();

	@Override
	public void method() {
		// Checking that some conditions are respected before calling 'method'.
		if(cando()) {// The condition has no meaning. Just here to compile
			obj.method();
		}
	}

	private boolean cando() {
		return new Random().nextInt(10) % 2 == 0;
	}
}


public class Q3 {
	public static void main(final String[] args) {
		final Object obj = new ObjectImpl2();

		IntStream.range(0, 10).forEach(i -> obj.method());
	}
}