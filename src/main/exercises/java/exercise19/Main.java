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

	@Override
	public String toString() {
		return "A{b=" + b + '}';
	}
}

class B {}

class C {
	@Inject
	A a;

	@Override
	public String toString() {
		return "C{a=" + a + '}';
	}
}

@interface Inject {}
