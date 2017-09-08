package insa.command.shape;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;

public class Invoker {
	public static void main(final String[] args) {
		new Invoker().example();
	}

	private final List<Command> cmds = new ArrayList<>();

	public void example() {
		final Rectangle rec = new Rectangle(1d, 2d, 10d, 20d);

		TranslateShapes command = new TranslateShapes();
		command.setShapeToMove(rec);
		command.setTranslation(new Point2D(10d, 20d));

		if(command.canExecute()) {
			command.execute();
			cmds.add(command);
		}

		undoCommands();
		redoCommands();
	}


	public void undoCommands() {
		cmds.stream().filter(cmd -> cmd instanceof Undoable).forEach(cmd -> ((Undoable)cmd).undo());
	}

	public void redoCommands() {
		cmds.stream().filter(cmd -> cmd instanceof Undoable).forEach(cmd -> ((Undoable)cmd).redo());
	}
}
