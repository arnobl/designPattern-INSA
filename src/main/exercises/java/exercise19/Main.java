package exercise19;

import javax.inject.Inject;

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

	C c;

	public A() {}

	@Override
	public String toString() {
		return "A{b=" + b + ", c=" + c + '}';
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
