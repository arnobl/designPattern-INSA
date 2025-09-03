package exercises.exercise5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUndoRedoHistory {
	UndoRedoHistory history;
	Undoable undoable;
	Undoable undoable2;

	@BeforeEach
	void setUp() {
		history = new UndoRedoHistory();
		undoable = Mockito.mock(Undoable.class);
		undoable2 = Mockito.mock(Undoable.class);
	}

	@Test
	void add() {
		history.add(undoable);
		assertEquals(1, history.getNbUndoables());
		assertEquals(0, history.getNbRedoables());
	}

	@Test
	void addNotNull() {
		history.add(null);
		assertEquals(0, history.getNbUndoables());
		assertEquals(0, history.getNbRedoables());
	}

	@Test
	void undo() {
		history.add(undoable);
		history.undo();
		Mockito.verify(undoable, Mockito.times(1)).undo();
		Mockito.verify(undoable, Mockito.never()).redo();
		assertEquals(0, history.getNbUndoables());
		assertEquals(1, history.getNbRedoables());
	}

	@Test
	void undoEmpty() {
		history.undo();
		Mockito.verify(undoable, Mockito.never()).undo();
		Mockito.verify(undoable, Mockito.never()).redo();
		assertEquals(0, history.getNbUndoables());
		assertEquals(0, history.getNbRedoables());
	}

	@Test
	void redoEmpty() {
		history.redo();
		Mockito.verify(undoable, Mockito.never()).undo();
		Mockito.verify(undoable, Mockito.never()).redo();
		assertEquals(0, history.getNbUndoables());
		assertEquals(0, history.getNbRedoables());
	}

	@Test
	void redoWithNoUndo() {
		history.add(undoable);
		history.redo();
		Mockito.verify(undoable, Mockito.never()).undo();
		Mockito.verify(undoable, Mockito.never()).redo();
		assertEquals(1, history.getNbUndoables());
		assertEquals(0, history.getNbRedoables());
	}

	@Test
	void undoUndoSingleElement() {
		history.add(undoable);
		history.undo();
		history.undo();
		Mockito.verify(undoable, Mockito.times(1)).undo();
		Mockito.verify(undoable, Mockito.never()).redo();
		assertEquals(0, history.getNbUndoables());
		assertEquals(1, history.getNbRedoables());
	}

	@Test
	void undoUndoTwoElements() {
		history.add(undoable);
		history.add(undoable2);
		history.undo();
		history.undo();
		Mockito.verify(undoable, Mockito.times(1)).undo();
		Mockito.verify(undoable2, Mockito.times(1)).undo();
		assertEquals(0, history.getNbUndoables());
		assertEquals(2, history.getNbRedoables());
	}

	@Test
	void redo() {
		history.add(undoable);
		history.undo();
		history.redo();
		Mockito.verify(undoable, Mockito.times(1)).undo();
		Mockito.verify(undoable, Mockito.times(1)).redo();
		assertEquals(1, history.getNbUndoables());
		assertEquals(0, history.getNbRedoables());
	}

	@Test
	void redo2Times() {
		history.add(undoable);
		history.undo();
		history.redo();
		history.undo();
		history.redo();
		Mockito.verify(undoable, Mockito.times(2)).undo();
		Mockito.verify(undoable, Mockito.times(2)).redo();
	}

	@Test
	void redoRedo() {
		history.add(undoable);
		history.undo();
		history.redo();
		history.redo();
		Mockito.verify(undoable, Mockito.times(1)).undo();
		Mockito.verify(undoable, Mockito.times(1)).redo();
		assertEquals(1, history.getNbUndoables());
		assertEquals(0, history.getNbRedoables());
	}

	@Test
	void undoundoredoredo() {
		history.add(undoable);
		history.add(undoable2);
		history.undo();
		history.undo();
		history.redo();
		history.redo();
		Mockito.verify(undoable, Mockito.times(1)).undo();
		Mockito.verify(undoable, Mockito.times(1)).redo();
		Mockito.verify(undoable2, Mockito.times(1)).undo();
		Mockito.verify(undoable2, Mockito.times(1)).redo();
	}

	@Test
	void cleanOnAdd() {
		history.add(undoable);
		history.undo();
		history.add(undoable2);
		assertEquals(1, history.getNbUndoables());
		assertEquals(0, history.getNbRedoables());
	}

	@Test
	void clearOnSizeMax() {
		history.setSizeMax(1);
		history.add(undoable);
		history.add(undoable2);

		assertEquals(1, history.getNbUndoables());
		assertEquals(0, history.getNbRedoables());
		assertEquals(undoable2, history.getLastUndo().get());
	}
}
