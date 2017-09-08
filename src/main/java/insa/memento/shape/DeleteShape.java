package insa.memento.shape;

import javafx.scene.Group;
import javafx.scene.shape.Shape;

// This command is also the Keeper of the memento pattern: it stores the memento
public class DeleteShape implements Command, Undoable {
	private Shape shapeToRemove;
	private Group formerParent;
	private int indexShape;

	public DeleteShape() {
		super();
	}

	public void setShapeToRemove(final Shape shape) {
		shapeToRemove = shape;
	}


	@Override
	public void execute() {
		// Creation of the memento to perform undo/redo operations later
		// In this case the memento is not an object (as depicted in the hardcopy of the class) but a set of attributes
		formerParent = (Group) shapeToRemove.getParent();
		indexShape = formerParent.getChildren().indexOf(shapeToRemove);

		// Executing the command
		redo();
	}

	@Override
	public boolean canExecute() {
		return shapeToRemove != null && shapeToRemove.getParent() instanceof Group;
	}

	@Override
	public void undo() {
		formerParent.getChildren().add(indexShape, shapeToRemove);
	}

	@Override
	public void redo() {
		formerParent.getChildren().remove(shapeToRemove);
	}
}
