package com.jr.module2.lesoon3.shared;

public interface Summator {
    void sum(int a, int b);

    default void info() {
        System.out.println("Summator info");
    }
}
