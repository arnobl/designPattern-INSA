package insa.exercise9;

import java.util.Objects;

abstract class BinaryNode implements Node {
	public final Node leftNode;
	public final Node rightNode;

	/**
	 * Initialises a binary node.
	 * @param left The left node.
	 * @param right The right node.
	 * @throws NullPointerException if one of the given argument is null.
	 */
	BinaryNode(final Node left, final Node right) {
		super();
		leftNode = Objects.requireNonNull(left);
		rightNode = Objects.requireNonNull(right);
	}
}
