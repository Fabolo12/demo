package com.jr.fabric;

import com.jr.models.Car;
import com.jr.models.PetrolCar;

class PetrolCarConstruct extends CarConstruct {

    private static int carCount = 0;

    @Override
    Car create() {
        System.out.println("Create PetrolCar");
        carCount++;
        // TODO: 16/10/23 logic...
        return new PetrolCar();
    }
}
