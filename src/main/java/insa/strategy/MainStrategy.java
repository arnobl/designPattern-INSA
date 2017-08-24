package insa.strategy;

import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainStrategy {
	public static void main(final String[] args) {
		final SortedList<Integer> list = new SortedList<>();
		list.addAll(IntStream.range(0, 5).map(i -> new Random().nextInt(10)).boxed().collect(Collectors.toList()));
		list.sort();

		Collections.shuffle(list);
		list.setSortingStrategy(new QuickSort<>(list));
		list.sort();

		Collections.shuffle(list);
		list.sort();
	}
}
