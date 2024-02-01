package com.jr.module3.lesson11.fabric.american;

import com.jr.module3.lesson11.fabric.Coffee;
import com.jr.module3.lesson11.fabric.CoffeeType;
import com.jr.module3.lesson11.fabric.GeneralFabric;

public class AmericanFabric implements GeneralFabric {

    @Override
    public Coffee create(final CoffeeType type) {
        return switch (type) {
            case ESPRESSO -> new EspressoAmericanCoffee();
            case LATE -> new LateAmericanCoffee();
            default -> throw new IllegalStateException(type.name());
        };
    }
}
