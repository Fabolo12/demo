package com.jr.fabric;

import com.jr.models.Car;
import com.jr.models.CarType;

public class CarFabric {

    public static Car createCar(final CarType type) {
        final CarConstruct construct;

        // TODO: 16/10/23 show listeners
        if (type == CarType.ELECTRO_CAR) {
            construct = new ElectroCarConstruct();
        } else if (type == CarType.PETROL_CAR) {
            construct = new PetrolCarConstruct();
        } else if (type == CarType.HYBRID_CAR) {
            construct = new HybridCarConstruct();
        } else {
            throw new IllegalArgumentException(type.name());
        }
        return construct.create();
    }
}
