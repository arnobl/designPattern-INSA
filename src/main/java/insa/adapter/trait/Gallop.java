package insa.adapter.trait;

public interface Gallop {
	default void gallop() {
		System.out.println("Gallop");
	}
}
