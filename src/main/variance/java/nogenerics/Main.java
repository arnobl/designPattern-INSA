package nogenerics;

public class Main {
	public static void main(final String[] args) {
		final Cow cow = new Cow();
		// Should not work
		cow.eat(new Meat());
		// We want to constraint to only:
		cow.eat(new Grass());

		final Animal animal = new Cow();
		// Should not work
		animal.eat(new Meat());
	}
}
