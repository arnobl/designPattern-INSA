package insa.strategy;

import java.util.List;
import java.util.Objects;

abstract class SortImpl<E extends Comparable<E>> implements SortingStrategy<E> {
	final List<E> list;

	SortImpl(final List<E> listToSort) {
		list = Objects.requireNonNull(listToSort);
	}
}
