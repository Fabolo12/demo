package com.jr.module2.lesoon2.models;

public class PetrolCar extends Car {
    private int petrol;

    public PetrolCar() {
        super(CarType.PETROL_CAR);
    }

    int getPetrol() {
        return petrol;
    }

    void setPetrol(final int petrol) {
        this.petrol = petrol;
    }
}
