package interpreter.basicVersion;

import java.util.Optional;

public class Interpreter {
	public static void main(final String[] args) {
		final String txt = "42 4 2 * +";
		final Context ctxt = new Context();

		// Verbose writing style
		for(final String token : txt.split(" ")) {
			final Optional<Expression> exp = FactoryExp.INSTANCE.createExp(token);
			if(exp.isPresent()) {
				exp.get().interpret(ctxt);
			}
		}
	}
}
