package lazyexample;

public class MainProxy {
	public static void main(final String[] args) {
		System.out.println("Creating an A");
		A a = new AImpl();
		System.out.println("Getting its B");
		a.getB();

		System.out.println("Creating a proxy A");
		a = new AProxy();
		System.out.println("Getting its B");
		a.getB();
	}
}
