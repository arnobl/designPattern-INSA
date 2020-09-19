package exercise7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMoveElement {
	MoveElement cmd;
	Element elt;
	int x;
	int y;
	int newX;
	int newY;

	@BeforeEach
	void setUp() {
		x = 1;
		y = 2;
		newX = -10;
		newY = 23;
		elt = new Element(x, y);
		// You may have to change the following code
		// to give elt to the command
		// and to give the new position to the command
		cmd = new MoveElement();
	}

	@Test
	void testExecute() {
		cmd.execute();
		assertEquals(newX, elt.getX());
		assertEquals(newY, elt.getY());
	}

	@Test
	void testExecuteUndo() {
		cmd.execute();
		cmd.undo();
		assertEquals(x, elt.getX());
		assertEquals(y, elt.getY());
	}

	@Test
	void testExecuteUndoRedo() {
		cmd.execute();
		cmd.undo();
		cmd.redo();
		assertEquals(newX, elt.getX());
		assertEquals(newY, elt.getY());
	}

	@Test
	void testExecuteUndoRedoUndo() {
		cmd.execute();
		cmd.undo();
		cmd.redo();
		cmd.undo();
		assertEquals(x, elt.getX());
		assertEquals(y, elt.getY());
	}

	@Test
	void testExecuteUndoUndo() {
		cmd.execute();
		cmd.undo();
		cmd.undo();
		assertEquals(x, elt.getX());
		assertEquals(y, elt.getY());
	}

	@Test
	void testExecuteUndoRedoRedo() {
		cmd.execute();
		cmd.undo();
		cmd.redo();
		cmd.redo();
		assertEquals(newX, elt.getX());
		assertEquals(newY, elt.getY());
	}
}
