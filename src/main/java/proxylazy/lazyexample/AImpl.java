package proxylazy.lazyexample;

public final class AImpl implements A {
	private B b;

	public AImpl() {
		super();
		b = new B();
	}

	@Override
	public B getB() {
		return b;
	}
}
