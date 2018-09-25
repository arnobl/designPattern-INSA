package generics;

public abstract class Animal<T extends Food> {
	public abstract Product eat(final T food);
}
