package singleton.injection;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class DependencyInjectionSingleton {
	public static void main(final String[] args) {
		final Injector injector = Guice.createInjector(new MyModule());

		System.out.println(injector.getInstance(B.class));
		System.out.println(injector.getInstance(B.class));
		// The two B objects are different (different instances [default behavior of a Guice factory)
		System.out.println(injector.getInstance(A.class));
		System.out.println(injector.getInstance(A.class));
		// The two A objects refer in fact to the same object
		// Our Guice factory 'MyModule' declares the class A as a singleton object
		// in the context of this factory
	}
}

class A {
}

class B{
}

class MyModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(A.class).asEagerSingleton();
	}
}
