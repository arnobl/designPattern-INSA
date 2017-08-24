package insa.abstractFactory.internal1;

import insa.abstractFactory.api.Polygon;
import insa.abstractFactory.api.Rectangle;
import insa.abstractFactory.api.ShapeFactory;

public class ShapeFactoryImpl implements ShapeFactory {
	@Override
	public Polygon createPolygon() {
		return new PolygonImpl();
	}

	@Override
	public Rectangle createRectangle() {
		return new RectangleImpl();
	}
}
