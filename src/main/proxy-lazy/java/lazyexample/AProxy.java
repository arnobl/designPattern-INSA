package lazyexample;

public class AProxy implements A {
	private AImpl proxiedA;

	@Override
	public B getB() {
		if(proxiedA == null) {
			proxiedA = new AImpl();
		}
		return proxiedA.getB();
	}
}
