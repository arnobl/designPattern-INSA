package interpreter.basicVersion;


import java.util.Optional;

final class FactoryExp {
	public static final FactoryExp INSTANCE = new FactoryExp();

	// Flyweight pattern
	private final Add add = new Add();
	private final Mult mult =  new Mult();

	private FactoryExp() {
		super();
	}

	public Optional<Expression> createExp(final String token) {
		if(token == null) {
			return Optional.empty();
		}

		switch(token) {
			case "+": return Optional.of(add);
			case "*": return Optional.of(mult);
		}
		try {
			return Optional.of(new Value(Double.valueOf(token)));
		}catch(final NumberFormatException ex) {
			return Optional.empty();
		}
	}
}
