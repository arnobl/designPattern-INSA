package insa.memento.basic;

public interface Mutable<T extends Memento> {
	T getState();

	default void setState(final Memento memento) {
		if(memento != null && memento.getObject() == this) {
			memento.applyMemento();
		}
	}
}
