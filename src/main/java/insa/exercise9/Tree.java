package insa.exercise9;


import java.util.Objects;

public class Tree {
	public final Node root;
	public final String name;

	public Tree(final Node rootNode, final String treeName) {
		super();
		root = Objects.requireNonNull(rootNode);
		name = Objects.requireNonNull(treeName);
	}
}
