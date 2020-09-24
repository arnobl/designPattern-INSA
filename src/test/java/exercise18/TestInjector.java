package exercise18;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestInjector {
	Injector injector;

	@BeforeEach
	void setUp() {
		injector = new Injector();
	}

	@Test
	void testNull() {
		assertNull(injector.createInstance(null));
	}

	@Test
	void testPrimitive() {
		assertNull(injector.createInstance(int.class));
	}

	@Test
	void testPrimitive2() {
		assertNull(injector.createInstance(Integer.class));
	}

	@Test
	void testNoDependency() {
		assertNotNull(injector.createInstance(B.class));
	}

	@Test
	void testNotSingleInstance() {
		assertNotSame(injector.createInstance(B.class), injector.createInstance(B.class));
	}

	@Test
	void testWithDependency() {
		final A a = injector.createInstance(A.class);
		assertNotNull(a);
		assertNull(a.c);
		assertNotNull(a.b);
	}

	@Test
	void testWithDeepDependency() {
		final C c = injector.createInstance(C.class);
		assertNotNull(c);
		assertNotNull(c.a);
		assertNotNull(c.a.b);
		assertNull(c.a.c);
	}

	@Test
	void testWithCyclicDependency() {
		final E e = injector.createInstance(E.class);
		assertNotNull(e);
		assertNotNull(e.f);
		assertNull(e.f.e);
	}

	@Disabled
	@Test
	void testArray() {
		assertNull(injector.createInstance(Object[].class));
	}

	@Disabled
	@Test
	void testNoDefaultConstructor() {
		assertNull(injector.createInstance(I.class));
	}

	static class I {
		public I(final int foo) {
		}
	}
}
