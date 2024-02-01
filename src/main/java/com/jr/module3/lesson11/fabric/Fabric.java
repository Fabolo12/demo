package com.jr.module3.lesson11.fabric;

import com.jr.module3.lesson11.fabric.american.AmericanFabric;
import com.jr.module3.lesson11.fabric.italy.ItalyFabric;

public class Fabric {
    public static GeneralFabric create(final CoffeeShopType type) {
        return switch (type) {
            case ITALY -> new ItalyFabric();
            case AMERICAN -> new AmericanFabric();
            default -> throw new IllegalStateException(type.name());
        };
    }
}
