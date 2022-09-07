package exercise7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUndoRedoHistory {
	UndoRedoHistory collector;
	Undoable undoable;
	Undoable undoable2;

	@BeforeEach
	void setUp() {
		collector = new UndoRedoHistory();
		undoable = Mockito.mock(Undoable.class);
		undoable2 = Mockito.mock(Undoable.class);
	}

	@Test
	void add() {
		collector.add(undoable);
		assertEquals(1, collector.getNbUndoables());
		assertEquals(0, collector.getNbRedoables());
	}

	@Test
	void addNotNull() {
		collector.add(null);
		assertEquals(0, collector.getNbUndoables());
		assertEquals(0, collector.getNbRedoables());
	}

	@Test
	void undo() {
		collector.add(undoable);
		collector.undo();
		Mockito.verify(undoable, Mockito.times(1)).undo();
		Mockito.verify(undoable, Mockito.never()).redo();
		assertEquals(0, collector.getNbUndoables());
		assertEquals(1, collector.getNbRedoables());
	}

	@Test
	void undoEmpty() {
		collector.undo();
		Mockito.verify(undoable, Mockito.never()).undo();
		Mockito.verify(undoable, Mockito.never()).redo();
		assertEquals(0, collector.getNbUndoables());
		assertEquals(0, collector.getNbRedoables());
	}

	@Test
	void redoEmpty() {
		collector.redo();
		Mockito.verify(undoable, Mockito.never()).undo();
		Mockito.verify(undoable, Mockito.never()).redo();
		assertEquals(0, collector.getNbUndoables());
		assertEquals(0, collector.getNbRedoables());
	}

	@Test
	void redoWithNoUndo() {
		collector.add(undoable);
		collector.redo();
		Mockito.verify(undoable, Mockito.never()).undo();
		Mockito.verify(undoable, Mockito.never()).redo();
		assertEquals(1, collector.getNbUndoables());
		assertEquals(0, collector.getNbRedoables());
	}

	@Test
	void undoUndoSingleElement() {
		collector.add(undoable);
		collector.undo();
		collector.undo();
		Mockito.verify(undoable, Mockito.times(1)).undo();
		Mockito.verify(undoable, Mockito.never()).redo();
		assertEquals(0, collector.getNbUndoables());
		assertEquals(1, collector.getNbRedoables());
	}

	@Test
	void undoUndoTwoElements() {
		collector.add(undoable);
		collector.add(undoable2);
		collector.undo();
		collector.undo();
		Mockito.verify(undoable, Mockito.times(1)).undo();
		Mockito.verify(undoable2, Mockito.times(1)).undo();
		assertEquals(0, collector.getNbUndoables());
		assertEquals(2, collector.getNbRedoables());
	}

	@Test
	void redo() {
		collector.add(undoable);
		collector.undo();
		collector.redo();
		Mockito.verify(undoable, Mockito.times(1)).undo();
		Mockito.verify(undoable, Mockito.times(1)).redo();
		assertEquals(1, collector.getNbUndoables());
		assertEquals(0, collector.getNbRedoables());
	}

	@Test
	void redo2Times() {
		collector.add(undoable);
		collector.undo();
		collector.redo();
		collector.undo();
		collector.redo();
		Mockito.verify(undoable, Mockito.times(2)).undo();
		Mockito.verify(undoable, Mockito.times(2)).redo();
	}

	@Test
	void redoRedo() {
		collector.add(undoable);
		collector.undo();
		collector.redo();
		collector.redo();
		Mockito.verify(undoable, Mockito.times(1)).undo();
		Mockito.verify(undoable, Mockito.times(1)).redo();
		assertEquals(1, collector.getNbUndoables());
		assertEquals(0, collector.getNbRedoables());
	}

	@Test
	void undoundoredoredo() {
		collector.add(undoable);
		collector.add(undoable2);
		collector.undo();
		collector.undo();
		collector.redo();
		collector.redo();
		Mockito.verify(undoable, Mockito.times(1)).undo();
		Mockito.verify(undoable, Mockito.times(1)).redo();
		Mockito.verify(undoable2, Mockito.times(1)).undo();
		Mockito.verify(undoable2, Mockito.times(1)).redo();
	}

	@Test
	void cleanOnAdd() {
		collector.add(undoable);
		collector.undo();
		collector.add(undoable2);
		assertEquals(1, collector.getNbUndoables());
		assertEquals(0, collector.getNbRedoables());
	}
}
