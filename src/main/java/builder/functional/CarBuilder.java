package builder.functional;

import builder.Car;

abstract class CarBuilder {
    protected String color;

    public abstract Car build();

    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }
}

class NewCarBuilder extends CarBuilder {
    protected String color = "black";

    private String model = "Renaut 9";
    private String engine = "petrol";
    private boolean air = false;
    private String seat = "fabric";

    public Car build() {
        return new Car(this.model, this.engine, this.air, this.seat, this.color);
    }

    public NewCarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public NewCarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public NewCarBuilder setAir(boolean air) {
        this.air = air;
        return this;
    }

    public NewCarBuilder setSeat(String seat) {
        this.seat = seat;
        return this;
    }

    public NewCarBuilder setColor(String color) {
        return (NewCarBuilder) super.setColor(color);
    }
}

class ReconditionedCarBuilder extends CarBuilder {
    private final Car oldCar;

    private boolean cleaned = true;
    private boolean tires = true;

    public ReconditionedCarBuilder(Car oldCar) {
        super();
        this.oldCar = oldCar;
    }

    public Car build() {
        /*
        Do some stuffs with cleaned and tires
        */
        if(this.color != null) {
            this.oldCar.setColor(this.color);
        }
        return this.oldCar;
    }

    public ReconditionedCarBuilder setCleaned(boolean cleaned) {
        this.cleaned = cleaned;
        return this;
    }

    public ReconditionedCarBuilder setNewTires(boolean tires) {
        this.tires = tires;
        return this;
    }

    public ReconditionedCarBuilder setColor(String color) {
        return (ReconditionedCarBuilder) super.setColor(color);
    }
}
