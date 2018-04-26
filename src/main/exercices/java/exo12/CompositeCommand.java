package exo12;

import java.util.Arrays;
import java.util.List;

public class CompositeCommand implements Command {
	private final List<Command> cmds;

	public CompositeCommand(final Command... cmds) {
		super();
		this.cmds = Arrays.asList(cmds);
	}

	@Override
	public void execute() {
		cmds.forEach(cmd -> cmd.execute());
	}
}
