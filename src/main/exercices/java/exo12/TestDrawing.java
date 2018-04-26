package exo12;

public class TestDrawing {
	Canvas drawingArea;

//	final Command selectRectMode =
//		() -> drawingArea.setEditingMode(EditingMode.RECTANGLE);
//
//	final Command dnd2DrawRect = () -> {
//		Robot.moveTo(Robot.getRandomPointIn(drawingArea));
//		//...
//	};

	public void testRectangleCreated() {
		new CompositeCommand(
			new SelectRectMode(drawingArea),
			new DnD2DrawRect(drawingArea)
		).execute();

//		new CompositeCommand(selectRectMode, dnd2DrawRect).execute();
	}
}
