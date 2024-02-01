package com.jr.module3.lesson11.singlton;

public class SimplePlusLazyLoad {
    private static SimplePlusLazyLoad instance;

    private String field = "SimplePlusLazyLoad";

    private SimplePlusLazyLoad() {
    }

    public static SimplePlusLazyLoad getInstance() {
        if (instance == null) {
            System.out.println("Create instance");
            instance = new SimplePlusLazyLoad();
        }
        return instance;
    }

    public void print() {
        System.out.println(field);
    }
}
