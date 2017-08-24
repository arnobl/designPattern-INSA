package insa.abstractFactory.internal2;

import insa.abstractFactory.api.Rectangle;
import java.awt.geom.Point2D;

public class RectangleImpl implements Rectangle {
	final javafx.scene.shape.Rectangle jfxRec;

	RectangleImpl() {
		super();
		jfxRec = new javafx.scene.shape.Rectangle(0d, 0d, 1d, 1d);
	}

	@Override
	public Point2D getPosition() {
		return new Point2D.Double(jfxRec.getX(), jfxRec.getY());
	}

	@Override
	public void setPosition(final double x, final double y) {
		jfxRec.setX(x);
		jfxRec.setY(y);
	}

	@Override
	public double getWidth() {
		return jfxRec.getWidth();
	}

	@Override
	public void setWidth(final double newWidth) {
		if(newWidth > 0d) {
			jfxRec.setWidth(newWidth);
		}
	}

	@Override
	public double getHeight() {
		return jfxRec.getHeight();
	}

	@Override
	public void setHeight(final double newHeight) {
		if(newHeight > 0d) {
			jfxRec.setHeight(newHeight);
		}
	}
}
