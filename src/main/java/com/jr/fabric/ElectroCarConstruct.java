package com.jr.fabric;

import com.jr.models.Car;
import com.jr.models.ElectroCar;

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
