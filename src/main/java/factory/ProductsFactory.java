package factory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProductsFactory {
	public P1 createP1() {
		return new P1();
	}

	public P2 createP2() {
		return new P2();
	}

	public List<P1> createNP1(final int nb) {
		return IntStream.range(0, nb).mapToObj(i -> new P1()).collect(Collectors.toList());
	}

	public Optional<Product> createFromString(final String className) {
		if(P1.class.getName().equals(className)) return Optional.of(createP1());
		if(P2.class.getName().equals(className)) return Optional.of(createP2());
		return Optional.empty();
	}

	// Etc.
}
