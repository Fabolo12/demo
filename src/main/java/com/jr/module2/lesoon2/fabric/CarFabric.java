package com.jr.module2.lesoon2.fabric;

import com.jr.module2.lesoon2.models.Car;
import com.jr.module2.lesoon2.models.CarType;

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
