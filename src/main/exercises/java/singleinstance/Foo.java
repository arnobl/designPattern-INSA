package singleinstance;

public class Foo {
	public int getFooFoo() {
		return RandomGenerator.INSTANCE.nextInt() * 20;
	}
}
