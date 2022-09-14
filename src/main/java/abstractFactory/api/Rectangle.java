package abstractFactory.api;

import java.awt.geom.Point2D;

public interface Rectangle extends Shape {
	Point2D getPosition();
	void setPosition(final double x, final double y);
	double getWidth();
	void setWidth(final double width);
	double getHeight();
	void setHeight(final double height);
}
