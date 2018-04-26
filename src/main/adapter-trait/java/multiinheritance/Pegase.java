package multiinheritance;

/*
This tricky code is outdated using Java 8 and traits (default interfaces).
 */
public class Pegase extends Horse implements Fly {
	// Looks like a Proxy but its an Adapter: the goal is two bind incompatible objects (Pegase with Bird)
	private final Bird bird = new Bird();

	@Override
	public void fly() {
		bird.fly();
	}
}
