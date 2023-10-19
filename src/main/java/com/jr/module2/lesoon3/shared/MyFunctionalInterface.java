package com.jr.module2.lesoon3.shared;

@FunctionalInterface
public interface MyFunctionalInterface {
    void method1();

    default void info() {
        System.out.println("Calculator info");
    }
}
