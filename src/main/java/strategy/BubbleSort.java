package strategy;

import java.util.List;

public class BubbleSort<E extends Comparable<E>> extends SortImpl<E> {

	public BubbleSort(final List<E> listToSort) {
		super(listToSort);
	}

	@Override
	public void sort() {
		System.out.printf("Before bubble sort: %s\n", list);
		bubbleSort();
		System.out.printf("After bubble sort: %s\n", list);
	}

	private void bubbleSort() {
		for(int outer = 0; outer < list.size() - 1; outer++) {
			for(int inner = 0; inner < list.size() - outer - 1; inner++) {
				if(list.get(inner).compareTo(list.get(inner + 1)) > 0) {
					swap(inner);
				}
			}
		}
	}

	private void swap(final int inner) {
		final E temp = list.get(inner);
		list.set(inner, list.get(inner + 1));
		list.set(inner + 1, temp);
	}
}
