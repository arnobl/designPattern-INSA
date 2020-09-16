package exercise11;

public class ExpFactory {
	public ArithmExp createExp(final String exp) {
		if("mult".equals(exp)) {
			return new Mult();
		}
		if("plus".equals(exp)) {
			return new Plus();
		}
		if("min".equals(exp)) {
			return new Min();
		}
		if("mod".equals(exp)) {
			return new Mod();
		}
		return null;
	}
}

interface ArithmExp {}
class Mult implements ArithmExp {}
class Plus implements ArithmExp {}
class Min implements ArithmExp {}
class Mod implements ArithmExp {}


