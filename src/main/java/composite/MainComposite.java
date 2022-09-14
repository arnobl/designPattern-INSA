package composite;

public class MainComposite {
	public static void main(final String[] args) {
		final Composite composite = new Composite();
		composite.addComponent(new Leaf());
		composite.addComponent(new Composite());
		System.out.println(composite.doSomething());
	}
}
