package com.jr.module2.lesoon3.shared;

public interface Calculator extends Checker {
    void sum(int a, int b);

    void div(int a, int b);

    void sub(int a, int b);

    void multi(int a, int b);

    default boolean check(int a, int b) {
        return a != 0 && b != 0;
    }

    default void info() {
        System.out.println("Calculator info");
    }
}
