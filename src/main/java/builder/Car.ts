
export class Car {
    constructor(
        private readonly model: string,
        private readonly engine: string,
        private readonly air: boolean,
        private readonly seat: string,
        private color: string) {
    }

    public setColor(color: string) {
        this.color = color;
    }
}
