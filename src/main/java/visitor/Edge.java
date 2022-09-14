package visitor;

import java.util.Arrays;
import java.util.List;

public class Edge implements GraphElt {
	final Node inputNode;
	final List<Node> outputNodes;

	public Edge(final Node input, final Node... outputs) {
		super();
		inputNode = input;
		outputNodes = Arrays.asList(outputs);
	}

	@Override
	public void accept(final VisitorGraph visitor) {
		visitor.visitEdge(this);
	}
}
