package singleton;

public class SingleInstanceExample {
	private static SingleInstanceExample instance = new SingleInstanceExample();

	public static SingleInstanceExample getInstance() {
		return instance;
	}

	public static void setInstance(final SingleInstanceExample instance) {
		if(instance != null) {
			SingleInstanceExample.instance = instance;
		}
	}

	public SingleInstanceExample() {
		super();
	}
}
