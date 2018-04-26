package inject;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import javax.inject.Inject;

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

class D {
	@Inject
	D d;

	@Override
	public String toString() {
		return "D{d=" + d + '}';
	}
}

class E {
	@Inject
	F f;

	@Override
	public String toString() { return "E{f=" + f + '}'; }
}

class F {
	@Inject
	E e;

	@Override
	public String toString() { return "F{e=" + e + '}'; }
}

public class Main {
	public static void main(final String[] args) {
		final Factory factory = new Factory();
		System.out.println("creating an A: " + factory.createObj(A.class));
		System.out.println("creating a B: " + factory.createObj(B.class));
		System.out.println("creating a C: " + factory.createObj(C.class));
		System.out.println("creating an String: " + factory.createObj(String.class));
		System.out.println("creating a D: " + factory.createObj(D.class));
		System.out.println("creating an E: " + factory.createObj(E.class));
		System.out.println("creating a F: " + factory.createObj(F.class));
	}
}

class Factory {
	<T> Optional<T> createObj(final Class<T> cl) {
		return createObjWithStack(cl, new HashSet<>());
	}

	private <T> Optional<T> createObjWithStack(final Class<T> cl, final Set<Class<?>> history) {
		if(cl.isPrimitive() || history.contains(cl)) {
			return Optional.empty();
		}

		try {
			final T instance = cl.newInstance();
			history.add(cl);

			Arrays.stream(cl.getDeclaredFields()).
				filter(field -> field.getType() != cl && field.isAnnotationPresent(Inject.class)).
				forEach(field -> createObjWithStack(field.getType(), history).ifPresent(value -> {
					try {
						field.set(instance, value);
					}catch(IllegalAccessException ex) {
						ex.printStackTrace();
					}
				}));

			return Optional.ofNullable(instance);
		}catch(final Exception ex) {
			return Optional.empty();
		}
	}
}
