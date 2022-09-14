package abstractFactory.internal2;

import abstractFactory.api.Polygon;
import abstractFactory.api.Rectangle;
import abstractFactory.api.ShapeFactory;

public class ShapeFactoryImplJFX implements ShapeFactory {
	@Override
	public Polygon createPolygon() {
		return new PolygonImpl();
	}

	@Override
	public Rectangle createRectangle() {
		return new RectangleImpl();
	}
}
