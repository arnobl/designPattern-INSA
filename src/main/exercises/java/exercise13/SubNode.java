package exercise13;

public class SubNode extends BinaryNode {
	public SubNode(final Node left, final Node right) {
		super(left, right);
	}

	@Override
	public void accept(final VisitorTree t) {
		t.visitSubNode(this);
	}
}
