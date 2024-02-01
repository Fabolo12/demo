package com.jr.module3.lesson11.fabricMethod.example1.logistic;

import com.jr.module3.lesson11.fabricMethod.example1.delivery.CarDelivery;
import com.jr.module3.lesson11.fabricMethod.example1.delivery.DeliverySystem;

public class CarLogistic implements LogisticSystem {

    @Override
    public DeliverySystem create(final String path) {
        return new CarDelivery();
    }
}
