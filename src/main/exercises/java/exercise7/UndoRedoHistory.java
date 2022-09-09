package exercise7;

import java.util.Optional;

public class UndoRedoHistory {
	public void add(final Undoable undoable) {
	}

	public void undo() {
	}

	public void redo() {
	}

	public int getNbUndoables() {
		return 0;
	}

	public int getNbRedoables() {
		return 0;
	}

	public void setSizeMax(final int size) {
	}

	public Optional<Undoable> getLastUndo() {
		return Optional.empty();
	}
}
