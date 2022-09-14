package interpreter.lambdaVersion;

import java.util.Arrays;

public class Interpreter {

	public static void main(final String[] args) {
		final String txt = "42 4 2 * +";
		final Context ctxt = new Context();

		Arrays.stream(txt.split(" ")).
			forEach(token -> FactoryExp.INSTANCE.createExp(token).
				ifPresent(exp -> exp.interpret(ctxt)));

		System.out.println(ctxt.getFinalValue());
	}
}
