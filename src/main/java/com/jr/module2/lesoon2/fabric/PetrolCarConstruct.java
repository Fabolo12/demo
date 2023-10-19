package com.jr.module2.lesoon2.fabric;

import com.jr.module2.lesoon2.models.Car;
import com.jr.module2.lesoon2.models.PetrolCar;

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
