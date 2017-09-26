package insa.visitor;

public class PrettyPrintGraphVisitor implements VisitorGraph {
	@Override
	public void visitGraph(final Graph graph) {
		//1: processing
		System.out.println("graph visited");
		//2: visitor algorithm
		// Example of why the method accept is necessary:
		// root is defined as a Node, an abstract class. So, we do not know at design time whether visitNode1 or visitNode2 must be called.
		// A very bad solution consists of using instanceof's to test the real type of root:
		// if(graph.root instanceof Node1) visitNode1((Node1) graph.root); ...
		// The use of instanceof's are useless since the dynamic binding of OOP languages does the job:
		// Calling graph.root.accept goes directly into the method accept of the concrete type that then calls the good visit method.
		graph.root.accept(this);
	}

	@Override
	public void visitNode1(final Node1 node) {
		//1 : processing
		System.out.printf("Node1 %s visited%n", node.name);
		//2: visitor algorithm
		node.edges.forEach(edge -> edge.accept(this));
	}

	@Override
	public void visitNode2(final Node2 node) {
		//1 : processing
		System.out.printf("Node2 %s visited%n", node.name);
		//2: visitor algorithm
		node.edges.forEach(edge -> edge.accept(this));
	}

	@Override
	public void visitEdge(final Edge edge) {
		System.out.printf("Edge from %s to %s visited%n", edge.inputNode, edge.outputNodes);
		edge.outputNodes.forEach(node -> node.accept(this));
	}
}
