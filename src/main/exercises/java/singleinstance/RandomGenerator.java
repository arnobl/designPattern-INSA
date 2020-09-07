package singleinstance;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A bad utility class to refactor
 */
public final class RandomGenerator {
	public static final RandomGenerator INSTANCE = new RandomGenerator();

	private RandomGenerator() {
		super();
	}

	public int nextInt() {
		return ThreadLocalRandom.current().nextInt();
	}
}
