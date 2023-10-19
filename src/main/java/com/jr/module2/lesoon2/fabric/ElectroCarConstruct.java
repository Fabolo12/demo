package com.jr.module2.lesoon2.fabric;

import com.jr.module2.lesoon2.models.Car;
import com.jr.module2.lesoon2.models.ElectroCar;

class ElectroCarConstruct extends CarConstruct {

    private static int carCount = 0;

    @Override
    Car create() {
        System.out.println("Create ElectroCar");
        carCount++;
        // TODO: 16/10/23 logic...
        return new ElectroCar();
    }
}
