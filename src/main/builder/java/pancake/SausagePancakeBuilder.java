package pancake;

import java.util.Collections;
import java.util.List;

public class SausagePancakeBuilder extends PancakeBuilder {
	@Override
	public Pastry createPastry() {
		// Do something complex here (instead of returning null): a special pastry
		return null;
	}

	@Override
	public List<Garnish> createGarnish() {
		// Do something complex here (instead of returning an empty list): cook the sausage.
		return Collections.emptyList();
	}
}
