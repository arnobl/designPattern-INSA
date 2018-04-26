package interpreter;

import java.util.ArrayDeque;

class Context extends ArrayDeque<Double> {
	public double getFinalValue() {
		if(size() != 1) throw new ArrayIndexOutOfBoundsException();

		return peek();
	}
}
