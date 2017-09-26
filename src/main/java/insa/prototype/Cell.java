package insa.prototype;

import java.util.Arrays;
import java.util.List;

// In java, avoid the use of the Cloneable interface
public class Cell { // implements Cloneable {

	public Cell(final Cell model) {
		super();
		copy(model);
	}

	public void copy(final Cell model) {
		//...
	}

	public List<Cell> cellDivision() {
		return Arrays.asList(new Cell(this), new Cell(this));
	}
}
