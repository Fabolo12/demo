package com.jr.module2.lesoon3.shared;

public class RemoteMain {
    public static void main(String[] args) {
        final Summator calculator = new CalculatorImpl();
        calculator.sum(1, 2);
    }
}
