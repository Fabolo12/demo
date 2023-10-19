package com.jr.module2.lesoon3.shared;

public class Main {
    public static void main(String[] args) {
        final Calculator calculator = new CalculatorImpl();
        final int a = 1;
        final int b = 2;
        if (calculator.check(a, b)) {
            calculator.sum(a, b);
        }

        final Calculator calculator2 = new PositivCalculator();

        System.out.println(calculator.check(-5, 5));
        System.out.println(calculator2.check(-5, 5));
        calculator.info();
    }
}
