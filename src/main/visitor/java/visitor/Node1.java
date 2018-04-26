package visitor;

public class Node1 extends Node {
	public Node1(final String nodename) {
		super(nodename);
	}

	@Override
	public void accept(final VisitorGraph visitor) {
		visitor.visitNode1(this);
	}
}
