package com.jr.module3.lesson11.strategy;

public class SumOperation implements MathOperation {
    @Override
    public double operation(final double first, final double second) {
        return first + second;
    }
}
