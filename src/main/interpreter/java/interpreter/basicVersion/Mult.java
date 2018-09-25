package interpreter.basicVersion;

class Mult implements Expression {
	@Override
	public void interpret(final Context ctxt) {
		ctxt.push(ctxt.pop() * ctxt.pop());
	}
}
