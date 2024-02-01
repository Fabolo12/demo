package com.jr.module3.lesson11.fabric;

public class Main {
    public static void main(String[] args) {
        print(CoffeeShopType.AMERICAN, CoffeeType.LATE);
        print(CoffeeShopType.AMERICAN, CoffeeType.ESPRESSO);
        print(CoffeeShopType.ITALY, CoffeeType.ESPRESSO);
    }

    private static void print(final CoffeeShopType shopType, final CoffeeType type) {
        final GeneralFabric generalFabric = Fabric.create(shopType);
        final Coffee coffee = generalFabric.create(type);
        System.out.println(coffee.getClass().getSimpleName());
    }
}
