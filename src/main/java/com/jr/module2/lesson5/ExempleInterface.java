package com.jr.module2.lesson5;

interface MyInterface1 {
    void method1();

    void method2();

    void method3();
}

@FunctionalInterface
interface MyInterface2 {
    void method1();

    default void method2() {

    }

    static void method3() {

    }

    String toString();
}

public class ExempleInterface {

}
