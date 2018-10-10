package exercise3;

import java.util.Optional;

public interface List<T> {
	Optional<T> get(final int i);

	boolean contains(final Object obj);

	void add(final T elt);
}
