package insa.builder.pancake;

import java.util.List;

public abstract class PancakeBuilder {
	public Pancake build() {
		return new Pancake(createPastry(), createGarnish());
	}

	public abstract Pastry createPastry();

	public abstract List<Garnish> createGarnish();
}
