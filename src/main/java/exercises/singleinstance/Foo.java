package exercises.singleinstance;

public class Foo {
	private int f;

	public Foo() {
		super();
		f = 10;
	}

	public int getFooFoo() {
		return RandomGenerator.INSTANCE.nextInt() * f;
	}

	public int getF() {
		return f;
	}

	public void setF(final int f) {
		this.f = f;
	}
}
