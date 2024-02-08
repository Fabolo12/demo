package com.jr.module3.lesson11.strategy;

public class DivOperation implements MathOperation {
    @Override
    public double operation(final double first, final double second) {
        return first / second;
    }
}
