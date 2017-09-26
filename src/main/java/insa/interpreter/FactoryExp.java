package insa.interpreter;

import java.util.Optional;

final class FactoryExp {
	public static final FactoryExp INSTANCE = new FactoryExp();

	private final Expression add = ctxt -> ctxt.push(ctxt.pop() + ctxt.pop());
	private final Expression mult = ctxt -> ctxt.push(ctxt.pop() * ctxt.pop());

	private FactoryExp() {
		super();
	}

	public Optional<Expression> createExp(final String token) {
		if(token == null) return Optional.empty();

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
