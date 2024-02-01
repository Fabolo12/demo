package com.jr.module3.lesson11.fabricMethod.example2;

import com.jr.module3.lesson11.fabricMethod.example1.logistic.BoatLogistic;
import com.jr.module3.lesson11.fabricMethod.example1.logistic.CarLogistic;
import com.jr.module3.lesson11.fabricMethod.example1.logistic.LogisticSystem;
import com.jr.module3.lesson11.fabricMethod.example1.logistic.LogisticType;
import com.jr.module3.lesson11.fabricMethod.example2.delivery.BoatDelivery;
import com.jr.module3.lesson11.fabricMethod.example2.delivery.CarDelivery;
import com.jr.module3.lesson11.fabricMethod.example2.delivery.DeliverySystem;

public class FabricMethod {
    public static DeliverySystem create(final LogisticType type) {
        return switch (type) {
            case CAR -> new CarDelivery();
            case BOAT -> new BoatDelivery();
            default -> throw new IllegalStateException(type.name());
        };
    }
}
