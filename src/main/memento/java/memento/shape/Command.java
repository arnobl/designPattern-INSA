package memento.shape;

public interface Command {
	void execute();

	boolean canExecute();
}
