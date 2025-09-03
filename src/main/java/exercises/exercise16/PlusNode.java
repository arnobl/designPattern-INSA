package exercises.exercise16;

public class PlusNode extends BinaryNode {
	public PlusNode(final Node left, final Node right) {
		super(left, right);
	}

	@Override
	public void accept(final VisitorTree t) {
		t.visitPlusNode(this);
	}
}

