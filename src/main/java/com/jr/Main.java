package com.jr;

import com.jr.fabric.CarFabric;
import com.jr.models.Car;
import com.jr.models.CarType;
import com.jr.models.Engine;
import com.jr.models.CarSystem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Car car1 = CarFabric.createCar(CarType.ELECTRO_CAR);
        final Car car2 = CarFabric.createCar(CarType.ELECTRO_CAR);
        final Car car3 = CarFabric.createCar(CarType.PETROL_CAR);
        List<Car> cars = List.of(car1, car2, car3);

        int sum = 0; // CTRL+ALT+L
        for (Car car : cars) {
            sum += car.getPrice();
        }
        System.out.println("Total sum: " + sum);

        int electroSum = 0;
        for (Car car : cars) {
            if (car.getType() == CarType.ELECTRO_CAR) {
                electroSum += car.getPrice();
            }
        }
        System.out.println("Total electrocar sum: " + electroSum);

        car1.setEngine(new Engine());
        car1.setSystem(new CarSystem());
        car1.start();
    }
}
