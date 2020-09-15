package exercise11;

public class ExpFactory {
	public ArithmExp createExp(final String exp) {
		return null;
	}
}

interface ArithmExp {}
class Mult implements ArithmExp {}
class Plus implements ArithmExp {}
class Min implements ArithmExp {}
class Mod implements ArithmExp {}


