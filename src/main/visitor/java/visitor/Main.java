package visitor;

public class Main {
	public static void main(final String[] args) {
		final Node n1 = new Node1("foo");
		final Node n2 = new Node2("bar");
		final Edge edge = new Edge(n1, n2);
		final Graph g = new Graph(n1);
		final VisitorGraph visitor = new PrettyPrintGraphVisitor();

		n1.edges.add(edge);

		g.accept(visitor);
	}
}
