package com.jr.module3.lesson11.fabric.italy;

import com.jr.module3.lesson11.fabric.Coffee;
import com.jr.module3.lesson11.fabric.CoffeeType;
import com.jr.module3.lesson11.fabric.GeneralFabric;

public class ItalyFabric implements GeneralFabric {

    @Override
    public Coffee create(final CoffeeType type) {
        return switch (type) {
            case ESPRESSO -> new EspressoItalyCoffee();
            case LATE -> new LateItalyCoffee();
            default -> throw new IllegalStateException(type.name());
        };
    }
}
