package insa.command.shape;

import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public class TranslateShapes implements Command, Undoable {
	private Shape shapeToMove;
	private Point2D translation;

	public TranslateShapes() {
		super();
	}

	public void setShapeToMove(final Shape shape) {
		shapeToMove = shape;
	}

	public void setTranslation(final Point2D trans) {
		translation = trans;
	}

	@Override
	public void execute() {
		shapeToMove.setTranslateX(shapeToMove.getTranslateX() + translation.getX());
		shapeToMove.setTranslateY(shapeToMove.getTranslateY() + translation.getY());
		System.out.printf("%s %f %f %n", shapeToMove, shapeToMove.getTranslateX(), shapeToMove.getTranslateY());
	}

	@Override
	public boolean canExecute() {
		return shapeToMove != null && translation != null;
	}

	@Override
	public void undo() {
		shapeToMove.setTranslateX(shapeToMove.getTranslateX() - translation.getX());
		shapeToMove.setTranslateY(shapeToMove.getTranslateY() - translation.getY());
		System.out.printf("%s %f %f %n", shapeToMove, shapeToMove.getTranslateX(), shapeToMove.getTranslateY());
	}

	@Override
	public void redo() {
		execute();
	}
}
