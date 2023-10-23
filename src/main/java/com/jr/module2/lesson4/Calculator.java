package com.jr.module2.lesson4;

public class Calculator<T extends Number> {
    public double sum(final T a, final T b) {
        return a.doubleValue()  + b.doubleValue();
    }

    public double sub(final T a, final T b) {
        return a.doubleValue() - b.doubleValue();
    }

    public double multi(final T a, final T b) {
        return a.doubleValue() * b.doubleValue();
    }

    public double div(final T a, final T b) {
        return a.doubleValue() / b.doubleValue();
    }
}
