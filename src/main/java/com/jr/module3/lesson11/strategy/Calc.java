package com.jr.module3.lesson11.strategy;

import lombok.Setter;

@Setter
public class Calc {
    private MathOperation operation;

    public double operation(final double first, final double second) {
        return operation.operation(first, second);
    }
}
