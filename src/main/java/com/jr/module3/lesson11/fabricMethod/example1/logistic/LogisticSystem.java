package com.jr.module3.lesson11.fabricMethod.example1.logistic;

import com.jr.module3.lesson11.fabricMethod.example1.delivery.DeliverySystem;

public interface LogisticSystem {
    DeliverySystem create(String path);
}
