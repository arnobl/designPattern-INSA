package exercises.exercise18;

import com.google.common.base.MoreObjects;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInjector {
	Injector injector;

	@BeforeEach
	void setUp() {
		injector = new Injector();
	}

	@Test
	void testNull() {
		assertTrue(injector.createInstance(null).isEmpty());
	}

	@Test
	void testPrimitive() {
		assertTrue(injector.createInstance(int.class).isEmpty());
	}

	@Test
	void testPrimitive2() {
		assertTrue(injector.createInstance(Integer.class).isEmpty());
	}

	@Test
	void testNoDependency() {
		assertTrue(injector.createInstance(B.class).isPresent());
	}

	@Test
	void testNotSingleInstance() {
		assertNotSame(injector.createInstance(B.class), injector.createInstance(B.class));
	}

	@Test
	void testWithDependency() {
		final Optional<A> opta = injector.createInstance(A.class);
		assertTrue(opta.isPresent());
		final A a = opta.get();
		assertNull(a.c);
		assertNotNull(a.b1);
		assertNotNull(a.b2);
		assertNotSame(a.b1, a.b2);
	}

	@Test
	void testWithDeepDependency() {
		final Optional<C> optc = injector.createInstance(C.class);
		assertTrue(optc.isPresent());
		final C c = optc.get();
		assertNotNull(c.a);
		assertNotNull(c.a.b1);
		assertNotNull(c.a.b2);
		assertNull(c.a.c);
	}

	@Test
	void testWithCyclicDependency() {
		final Optional<E> opte = injector.createInstance(E.class);
		assertTrue(opte.isPresent());
		final E e = opte.get();
		assertNotNull(e.f);
		assertNull(e.f.e);
	}

	@Test
	void testArray() {
		assertTrue(injector.createInstance(Object[].class).isEmpty());
	}

	@Test
	void testNoDefaultConstructor() {
		assertTrue(injector.createInstance(I.class).isEmpty());
	}

	@Test
	void primitiveField() {
		final Optional<G> optg = injector.createInstance(G.class);
		assertTrue(optg.isPresent());
		assertEquals(0, optg.get().i);
	}

	@Test
	void abstractClass() {
		assertTrue(injector.createInstance(H.class).isEmpty());
	}

	@Test
	void finalField() {
		final Optional<J> optj = injector.createInstance(J.class);
		assertTrue(optj.isPresent());
	}
}

abstract class H {
	public H() {}
}

class J {
	@Inject
	final A a = null;

	public J() {}
}


class A {
	@Inject
	B b1;

	@Inject
	B b2;

	C c;

	public A() {}

	@Override
	public String toString() {
		return "A{b=" + b1 + ", c=" + c + '}';
	}
}

class G {
	@Inject
	int i;

	public G() {}
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

	public E() {}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("f", f).toString();
	}
}

class F {
	@Inject
	E e;

	public F() {}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("e", e).toString();
	}
}

class I {
	public I(final int foo) {
	}
}
