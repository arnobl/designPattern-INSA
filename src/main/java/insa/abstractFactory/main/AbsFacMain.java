package insa.abstractFactory.main;

import insa.abstractFactory.api.Polygon;
import insa.abstractFactory.api.Rectangle;
import insa.abstractFactory.api.ShapeFactory;
import insa.abstractFactory.internal1.ShapeFactoryImpl;
import insa.abstractFactory.internal2.ShapeFactoryImplJFX;

public class AbsFacMain {
	public static void main(String[] args) {
		// The single line that refers to the first implementation.
		ShapeFactory factory = new ShapeFactoryImpl();

		useTheFactory(factory);

		// A factory can be dynamically changed to change the implementation.
		factory = new ShapeFactoryImplJFX();

		useTheFactory(factory);
	}

	static void useTheFactory(final ShapeFactory factory) {
		// No use of constructors
		// No use of concrete type.
		Polygon polygon = factory.createPolygon();
		Rectangle rectangle = factory.createRectangle();

		System.out.printf("Polygon created: %s\n", polygon);
		System.out.printf("Rectangle created: %s\n", rectangle);
	}
}
