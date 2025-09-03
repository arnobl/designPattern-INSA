package exercises.exercise16;

public class Main {
	public static void main(final String[] args) {
		final Tree tree = new Tree(new SubNode(new ValueNode(1), new ValueNode(2)), "foo");

		tree.accept(new VisitorPostFix());
		// tree.accept(new VisitorCompute());
	}
}
