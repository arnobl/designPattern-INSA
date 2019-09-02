package injectGuice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceExample {
	public static void main(final String[] args) {
		final Injector injector = Guice.createInjector(new MyModule());

		System.out.println(injector.getInstance(B.class));
		System.out.println(injector.getInstance(B.class));
		System.out.println(injector.getInstance(C.class));
		System.out.println(injector.getInstance(C.class));
		System.out.println(injector.getInstance(A.class));
		System.out.println(injector.getInstance(A.class));
		System.out.println(injector.getInstance(D.class));
		System.out.println(injector.getInstance(D.class));
	}
}

interface C {
}
class A {
}
class B {
}
interface D{
}

class MyModule extends AbstractModule {
	private static class CImpl implements C {}
	private final D d = new D() {};

	@Override
	protected void configure() {
		// Always returns the same A object
		bind(A.class).asEagerSingleton();
		// Use a private implementation of the service
		bind(C.class).toProvider(() -> new CImpl());
		// Returns a given object
		bind(D.class).toInstance(d);
	}
}
