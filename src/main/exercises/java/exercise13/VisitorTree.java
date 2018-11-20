package exercise13;

public interface VisitorTree {
	void visitTree(final Tree tree);
	void visitPlusNode(final PlusNode n);
	void visitSubNode(final SubNode n);
	void visitValueNode(final ValueNode n);
}
