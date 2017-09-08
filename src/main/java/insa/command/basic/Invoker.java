package insa.command.basic;

import java.util.Arrays;
import java.util.List;

public class Invoker {
	public static void main(final String[] args) {
		// Can store commands as objects
		final List<Command> cmds = Arrays.asList(new Command1(), new Command1(), new Command2());

		// Since commands can be stored, can be executed on demand.
		cmds.forEach(cmd -> cmd.execute());
	}
}
