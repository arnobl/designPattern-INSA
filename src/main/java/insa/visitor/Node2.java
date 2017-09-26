package insa.visitor;

public class Node2 extends Node {
	public Node2(final String nodename) {
		super(nodename);
	}

	@Override
	public void accept(final VisitorGraph visitor) {
		visitor.visitNode2(this);
	}
}
