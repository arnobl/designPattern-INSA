package insa.interpreter;

@FunctionalInterface
public interface Expression {
	void interpret(final Context ctxt);
}
