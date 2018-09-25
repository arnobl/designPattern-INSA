package nogenerics;

public class Cow extends Animal {
	// This is not possible to set the food parameter with the type Grass:
	// Parameters of Java methods are invariants:
	// they can be a subtype of the upper parameter type (but can be a super type)
	// The return type is covariant: you can specify a sub-type of the upper return type
	@Override
	public Milk eat(final Food food) {
		return new Milk();
	}
}
