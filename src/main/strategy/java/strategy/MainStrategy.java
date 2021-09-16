package strategy;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class MainStrategy {
	public static void main(final String[] args) {
		final SortedList<Integer> list = new SortedList<>();

		list.addAll(ThreadLocalRandom
			.current()
			.ints(5, 0, 10)
			.boxed()
			.collect(Collectors.toList())
		);

		list.sort();

		Collections.shuffle(list);
		list.setSortingStrategy(new QuickSort<>(list));
		list.sort();

		Collections.shuffle(list);
		list.sort();
	}
}
