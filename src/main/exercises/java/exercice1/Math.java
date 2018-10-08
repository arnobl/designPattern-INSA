package exercice1;

public final class Math {
	public static final double PI = 3.141592653589793D;

	public static double toRadians(final double angdeg) {
		return angdeg / 180.0 * PI;
	}

	public static double toDegrees(final double angrad) {
		return angrad * 180.0 / PI;
	}
}
