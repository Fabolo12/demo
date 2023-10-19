package com.jr.module2.lesoon2.models;

public abstract class Car {
    private String model;
    private int price;

    private final CarType type;

    private Engine engine;
    private CarSystem carSystem;

    public Car(final CarType type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(final String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(final int price) {
        this.price = price;
    }

    public CarType getType() {
        return type;
    }

    public void setEngine(final Engine engine) {
        this.engine = engine;
    }

    public void setSystem(final CarSystem carSystem) {
        this.carSystem = carSystem;
    }

    public void start() {
        engine.start();
        carSystem.start();
    }
}
