package exercise19;

public class Main {
	public static void main(final String[] args) {
		final var injector = new Injector();
	}
}


class Injector {
}


class A {
	@Inject
	B b;

	public A() {}

	@Override
	public String toString() {
		return "A{b=" + b + '}';
	}
}

class B {
	public B() {}
}

class C {
	@Inject
	A a;

	public C() {}

	@Override
	public String toString() {
		return "C{a=" + a + '}';
	}
}

@interface Inject {}
