package insa.visitor;

import java.util.ArrayList;
import java.util.List;

// There exists two different types of Nodes: Node1 and Node2.
// No accept method in abstract classes, but defined in each of there concrete sub-classes.
public abstract class Node implements GraphElt {
	final String name;
	final List<Edge> edges;

	public Node(final String nodename) {
		super();
		edges = new ArrayList<>();
		name = nodename;
	}
}
