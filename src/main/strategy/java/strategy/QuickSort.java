package strategy;

import java.util.Collections;
import java.util.List;

public class QuickSort<E extends Comparable<E>> extends SortImpl<E> {

	public QuickSort(final List<E> listToSort) {
		super(listToSort);
	}

	@Override
	public void sort() {
		System.out.printf("Before quick sort: %s\n", list);
		sort(0, list.size() - 1);
		System.out.printf("After quick sort: %s\n", list);
	}

	private void sort(final int from, final int to) {
		if(from < to) {
			int left = from + 1;
			int right = to;
			final E pivotValue = list.get(from);

			while(left <= right) {
				// left <= to -> limit protection
				while(left <= to && pivotValue.compareTo(list.get(left)) >= 0) {
					left++;
				}
				// right > from -> limit protection
				while(right > from && pivotValue.compareTo(list.get(right)) < 0) {
					right--;
				}
				if(left < right) {
					Collections.swap(list, left, right);
				}
			}

			Collections.swap(list, from, left - 1);
			sort(from, right - 1);
			sort(right + 1, to);
		}
	}
}
