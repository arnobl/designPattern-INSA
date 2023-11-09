package builder;

public class Car {
    private final String model;
    private final String engine;
    private final boolean air;
    private final String seat;
    private String color;

    public Car(String model, String engine, boolean air, String seat, String color) {
        this.model = model;
        this.engine = engine;
        this.air = air;
        this.seat = seat;
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
