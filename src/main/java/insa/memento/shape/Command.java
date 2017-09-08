package insa.memento.shape;

public interface Command {
	void execute();

	boolean canExecute();
}
