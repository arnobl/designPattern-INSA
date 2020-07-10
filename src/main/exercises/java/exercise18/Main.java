package exercise18;

import com.google.common.base.MoreObjects;
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

class E {
	@Inject
	F f;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("f", f).toString();
	}
}

class F {
	@Inject
	E e;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("e", e).toString();
	}
}
