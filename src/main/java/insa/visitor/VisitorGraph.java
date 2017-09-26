package insa.visitor;

public interface VisitorGraph {
	void visitGraph(final Graph graph);

	void visitNode1(final Node1 node);

	void visitNode2(final Node2 node);

	void visitEdge(final Edge edge);
}
