package memento.basic;

import java.util.Map;
import java.util.Optional;
import java.util.WeakHashMap;

public final class Keeper {
	public static final Keeper INSTANCE = new Keeper();

	private final Map<Object, Memento> mementos;

	private Keeper() {
		super();
		// Tricky way to avoid memory leaks: https://docs.oracle.com/javase/7/docs/api/java/util/WeakHashMap.html
		mementos = new WeakHashMap<>();
	}


	public void addMemento(final Memento memento) {
		if(memento != null) {
			// In this implementation, we keep only a single memento for one object
			mementos.put(memento.getObject(), memento);
		}
	}

	public Optional<Memento> getMemento(final Object object) {
		if(object == null) return Optional.empty();
		return Optional.ofNullable(mementos.get(object));
	}
}
