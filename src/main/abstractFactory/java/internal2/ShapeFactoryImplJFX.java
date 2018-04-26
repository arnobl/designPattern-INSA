package internal2;

import api.Polygon;
import api.Rectangle;
import api.ShapeFactory;

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
