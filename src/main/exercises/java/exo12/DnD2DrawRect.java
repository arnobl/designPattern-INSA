package exo12;

public class DnD2DrawRect implements Command {
	final Canvas drawingArea;

	public DnD2DrawRect(final Canvas drawingArea) {
		this.drawingArea = drawingArea;
	}

	@Override
	public void execute() {
		Robot.moveTo(Robot.getRandomPointIn(drawingArea));
		//...
	}
}
