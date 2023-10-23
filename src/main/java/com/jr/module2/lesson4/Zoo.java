package com.jr.module2.lesson4;

public class Zoo<E> {
    public static <T> void print2(final T value) {
        System.out.println(value);
    }

    public <T> void print1(final T value) {
        System.out.println(value);
    }
}
