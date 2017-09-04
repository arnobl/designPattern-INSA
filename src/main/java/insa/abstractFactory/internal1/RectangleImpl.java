package insa.abstractFactory.internal1;

import insa.abstractFactory.api.Rectangle;
import java.awt.geom.Point2D;

class RectangleImpl implements Rectangle {
	final Point2D position;
	double width;
	double height;

	RectangleImpl() {
		super();
		position = new Point2D.Double();
		width = 1d;
		height = 1d;
	}

	@Override
	public Point2D getPosition() {
		return position;
	}

	@Override
	public void setPosition(final double x, final double y) {
		position.setLocation(x, y);
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public void setWidth(final double newWidth) {
		if(newWidth > 0d) {
			width = newWidth;
		}
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public void setHeight(final double newHeight) {
		if(newHeight > 0d) {
			height = newHeight;
		}
	}
}
