package strategy;

import java.util.ArrayList;

public class SortedList<E extends Comparable<E>> extends ArrayList<E> {
	SortingStrategy<E> strategy;

	public SortedList() {
		super();
		strategy = new BubbleSort<>(this);
	}

	public void sort() {
		strategy.sort();
	}

	public void setSortingStrategy(final SortingStrategy<E> newStrategy) {
		if(newStrategy != null) {
			strategy = newStrategy;
		}
	}
}
