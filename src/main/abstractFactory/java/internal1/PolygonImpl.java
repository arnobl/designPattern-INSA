package internal1;

import api.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

class PolygonImpl implements Polygon {
	final List<Point2D> points;

	PolygonImpl() {
		super();
		points = new ArrayList<>();
	}

	@Override
	public void addPoint(final Point2D pt) {
		if(pt != null) {
			points.add(pt);
		}
	}
}
