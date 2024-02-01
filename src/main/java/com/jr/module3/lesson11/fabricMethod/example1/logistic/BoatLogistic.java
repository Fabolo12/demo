package com.jr.module3.lesson11.fabricMethod.example1.logistic;

import com.jr.module3.lesson11.fabricMethod.example1.delivery.BoatDelivery;
import com.jr.module3.lesson11.fabricMethod.example1.delivery.DeliverySystem;

public class BoatLogistic implements LogisticSystem {
    @Override
    public DeliverySystem create(final String path) {
        return new BoatDelivery();
    }
}
