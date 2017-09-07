package insa.adapter.multiinheritance;

public class Bird implements Fly {
	@Override
	public void fly() {
		System.out.println("fly");
	}
}
