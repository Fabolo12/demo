package com.jr.module3.lesson11.fabricMethod.example1;

import com.jr.module3.lesson11.fabricMethod.example1.logistic.FabricMethod;
import com.jr.module3.lesson11.fabricMethod.example1.logistic.LogisticType;

public class Main {
    public static void main(String[] args) {
        final FabricMethod fabricMethod = new FabricMethod();
        fabricMethod.create(LogisticType.BOAT).create("").delivery();
        fabricMethod.create(LogisticType.CAR).create("").delivery();
    }
}
