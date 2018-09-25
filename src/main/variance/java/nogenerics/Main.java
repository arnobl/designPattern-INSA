package nogenerics;

public class Main {
	public static void main(final String[] args) {
		final Cow cow = new Cow();
		// Should not work
		cow.eat(new Meat());

		final Animal animal = new Cow();
		// Should not work
		animal.eat(new Meat());
	}
}
