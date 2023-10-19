package com.jr.module2.lesoon2.models;

public class ElectroCar extends Car {
    private int electro;

    public ElectroCar() {
        super(CarType.ELECTRO_CAR);
    }

    int getElectro() {
        return electro;
    }

    void setElectro(final int electro) {
        this.electro = electro;
    }
}
