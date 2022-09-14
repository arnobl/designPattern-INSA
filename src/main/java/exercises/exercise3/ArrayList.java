package exercises.exercise3;

import java.util.Arrays;
import java.util.Optional;

public class ArrayList<T> implements List<T> {
	T[] data;

	//...

	@Override
	public Optional<T> get(final int i) {
		return i>=0 && i<data.length ?
			Optional.ofNullable(data[i]) :
			Optional.empty();
	}

	@Override
	public boolean contains(final Object obj) {
		return Arrays.
			stream(data).
			anyMatch(elt -> elt.equals(obj));
	}

	@Override
	public void add(final T elt) {

	}
}
