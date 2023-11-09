import { Car } from "../Car";

export abstract class CarBuilder {
    protected color: string | undefined;

    public abstract build(): Car;

    public setColor(color: string): this {
        this.color = color;
        return this;
    }
}

export class NewCarBuilder extends CarBuilder {
    protected color: string = "black";

    private model: string = "Renaut 9";
    private engine: string = "petrol";
    private air: boolean = false;
    private seat: string = "fabric";

    public build(): Car {
        return new Car(this.model, this.engine, this.air, this.seat, this.color);
    }

    public setModel(model: string): this {
        this.model = model;
        return this;
    }

    public setEngine(engine: string): this {
        this.engine = engine;
        return this;
    }

    public setAir(air: boolean): this {
        this.air = air;
        return this;
    }

    public setSeat(seat: string): this {
        this.seat = seat;
        return this;
    }
}

export class ReconditionedCarBuilder extends CarBuilder {
    private readonly oldCar: Car;

    private cleaned: boolean = true;
    private tires: boolean = true;

    public constructor(oldCar: Car) {
        super();
        this.oldCar = oldCar;
    }

    public build(): Car {
        /*
        Do some stuffs with cleaned and tires
        */
        if(this.color !== undefined) {
            this.oldCar.setColor(this.color);
        }
        return this.oldCar;
    }

    public setCleaned(cleaned: boolean): this {
        this.cleaned = cleaned;
        return this;
    }

    public setNewTires(tires: boolean): this {
        this.tires = tires;
        return this;
    }
}
