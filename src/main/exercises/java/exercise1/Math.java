package exercise1;

public final class Math {
	public static final Math INSTANCE = new Math();

	public final double pi = 3.141592653589793D;

	private Math() {
		super();
	}

	public double toRadians(final double angdeg) {
		return angdeg / 180.0 * pi;
	}

	public double toDegrees(final double angrad) {
		return angrad * 180.0 / pi;
	}
}
