import { Car } from "../Car";

export abstract class CarBuilder {
    protected color: string | undefined;

    public abstract build(): Car;

    public setColor(color: string): void {
        this.color = color;
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

    public setModel(model: string): void {
        this.model = model;
    }

    public setEngine(engine: string): void {
        this.engine = engine;
    }

    public setAir(air: boolean): void {
        this.air = air;
    }

    public setSeat(seat: string): void {
        this.seat = seat;
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

    public setCleaned(cleaned: boolean): void {
        this.cleaned = cleaned;
    }

    public setNewTires(tires: boolean): void {
        this.tires = tires;
    }
}
