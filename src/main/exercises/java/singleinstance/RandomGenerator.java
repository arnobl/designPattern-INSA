package singleinstance;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A bad utility class to refactor
 */
public final class RandomGenerator {
	private RandomGenerator() {
		super();
	}

	public static int nextInt() {
		return ThreadLocalRandom.current().nextInt();
	}
}
