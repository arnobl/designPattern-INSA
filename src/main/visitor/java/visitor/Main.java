package visitor;

public class Main {
	public static void main(final String[] args) {
		// Creating the model
		final Node n1 = new Node1("foo");
		final Node n2 = new Node2("bar");
		final Edge edge = new Edge(n1, n2);
		final Graph g = new Graph(n1);
		n1.edges.add(edge);

		// Creating the visitor
		final VisitorGraph visitor = new PrettyPrintGraphVisitor();

		// Asking the model to accept the visitor (to launch the visit)
		g.accept(visitor);
	}
}
