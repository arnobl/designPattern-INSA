package proxylazy.lazyexample;

import proxylazy.lazyexample.AImpl;
import proxylazy.lazyexample.B;

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
