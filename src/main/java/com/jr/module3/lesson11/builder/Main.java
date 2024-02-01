package com.jr.module3.lesson11.builder;

public class Main {
    public static void main(String[] args) {
        final House.Builder builder = new House.Builder();
        final House house = builder.withField1(10)
                .withField3(5)
                .withField5("QWERTY")
                .build();
        final House house2 = builder.build();
        final House house3 = builder.build();
        System.out.println(house);
        System.out.println(house2);
        System.out.println(house3);
    }
}
