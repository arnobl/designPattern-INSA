package exercises.exercise16;

public class ValueNode implements Node {
	public final int val;

	public ValueNode(final int valNode) {
		super();
		val = valNode;
	}

	@Override
	public void accept(final VisitorTree t) {
		t.visitValueNode(this);
	}
}
