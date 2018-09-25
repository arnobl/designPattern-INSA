package interpreter.basicVersion;

class Value implements Expression {
	protected double value;

	public Value(final double val) {
		super();
		value = val;
	}

	@Override
	public void interpret(final Context ctxt) {
		ctxt.push(value);
	}
}
