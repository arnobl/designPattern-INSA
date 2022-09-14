package interpreter.basicVersion;

import interpreter.basicVersion.Context;

@FunctionalInterface
public interface Expression {
	void interpret(final Context ctxt);
}
