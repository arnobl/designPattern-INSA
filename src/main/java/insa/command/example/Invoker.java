package insa.command.example;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
	final List<Runnable> cmds = new ArrayList<>();
	
	public void addCommand(final Runnable cmd) {
		System.out.println(cmd);
		cmds.add(cmd);
	}
	
	public void run() {
		cmds.forEach(cmd -> cmd.run());
	}
}
