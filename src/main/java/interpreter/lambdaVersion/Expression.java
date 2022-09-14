package interpreter.lambdaVersion;

@FunctionalInterface
public interface Expression {
	void interpret(final Context ctxt);
}
