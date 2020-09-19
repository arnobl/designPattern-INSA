package exercise7;

public class MoveElement implements Command, Undoable {
	@Override
	public void execute() {

	}

	@Override
	public void undo() {

	}

	@Override
	public void redo() {

	}
}


class Element {
	private int x;
	private int y;

	public Element(final int x, final int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(final int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(final int y) {
		this.y = y;
	}
}
