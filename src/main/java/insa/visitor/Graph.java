package insa.visitor;

public class Graph implements GraphElt {
	final Node root;

	public Graph(final Node rootNode) {
		super();
		root = rootNode;
	}

	@Override
	public void accept(final VisitorGraph visitor) {
		visitor.visitGraph(this);
	}
}
