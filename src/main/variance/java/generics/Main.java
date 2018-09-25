package generics;

public class Main {
	public static void main(final String[] args) {
		final Cow cow = new Cow();
		// Do not compile
//		cow.eat(new Meat());
		// OK
		cow.eat(new Grass());

		final Animal<?> animal = new Cow();
		// Does not compile since the generic type is not specified
//		animal.eat(new Meat());

		// Does not compile since the generics are not compatible
//		final Animal<Meat> animal2 = new Cow();

		// OK
		final Animal<Grass> animal3 = new Cow();
		animal3.eat(new Grass());
	}
}
