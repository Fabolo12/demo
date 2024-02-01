package com.jr.module3.lesson11.fabricMethod.example1.logistic;

public class FabricMethod {
    public LogisticSystem create(final LogisticType type) {
        return switch (type) {
            case CAR -> new CarLogistic();
            case BOAT -> new BoatLogistic();
            default -> throw new IllegalStateException(type.name());
        };
    }
}
