package generics;

public class Cow extends Animal<Grass> {
	// Java generics are covariant.
	// thanks to them you can precise the type of a parameter
	// to overcome the contra-variance of parameters
	@Override
	public Milk eat(final Grass food) {
		return new Milk();
	}
}
