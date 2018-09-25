package exo12;

public class SelectRectMode implements Command {
	final Canvas drawingArea;

	public SelectRectMode(final Canvas canvas) {
		this.drawingArea = canvas;
	}

	@Override
	public void execute() {
		drawingArea.setEditingMode(EditingMode.RECTANGLE);
	}
}
