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
}

class B {}

class C {
	@Inject
	A a;
}

@interface Inject {}
