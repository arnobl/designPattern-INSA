package insa.adapter.trait;

// A trait defines a concern that has behavior and that can be composed with other traits and classes.
// In its original definition, a trait is defined as having no state (no attribute).
// Scala traits go beyond this definition (they can have attributes).
public interface Fly {
	default void fly() {
		System.out.println("fly");
	}
}
