package insa.interpreter;

class Add implements Expression {
	@Override
	public void interpret(final Context ctxt) {
		ctxt.push(ctxt.pop() + ctxt.pop());
	}
}