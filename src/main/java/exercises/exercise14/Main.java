package exercises.exercise14;

interface Canard {
	String coincoin();
	String danser();
}

class Loup {
	public String coincoin() {
		return "COIN COIN OUUUH";
	}

	public String danser() {
		return "¯\\_( )_/¯";
	}

	public String manger(final Canard c) {
		return "¯\\_(@@)_/¯";
	}
}


public class Main {
	public static void main(final String[] args) {
		final Loup loup = new Loup();

//		Canard canard = loup; // does not compile: nominal typing
//		canard.coincoin();
//		canard.danser();
	}
}
