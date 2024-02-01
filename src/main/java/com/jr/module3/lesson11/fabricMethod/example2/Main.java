package com.jr.module3.lesson11.fabricMethod.example2;

import com.jr.module3.lesson11.fabricMethod.example1.logistic.LogisticType;

public class Main {
    public static void main(String[] args) {
        FabricMethod.create(LogisticType.CAR).delivery();
        FabricMethod.create(LogisticType.BOAT).delivery();
    }
}
