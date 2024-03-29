package abstractFactory.internal2;

import abstractFactory.api.Polygon;
import java.awt.geom.Point2D;

class PolygonImpl implements Polygon {
	final javafx.scene.shape.Polygon jfxPol;

	PolygonImpl() {
		super();
		jfxPol = new javafx.scene.shape.Polygon();
	}

	@Override
	public void addPoint(final Point2D pt) {
		if(pt != null) {
			jfxPol.getPoints().addAll(pt.getX(), pt.getY());
		}
	}
}
