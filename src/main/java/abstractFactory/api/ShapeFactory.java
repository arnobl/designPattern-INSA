package abstractFactory.api;

// Contrary the Factory pattern, the base factory of the pattern Abstract Factory is... abstract (more specifically is an interface)
// This abstract factory defines the services the concrete factories must implement.
public interface ShapeFactory {
	Polygon createPolygon();

	Rectangle createRectangle();
}
