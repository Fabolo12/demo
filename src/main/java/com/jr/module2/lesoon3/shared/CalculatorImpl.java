package com.jr.module2.lesoon3.shared;

class CalculatorImpl implements Calculator, Checker, Summator {
    @Override
    public void sum(final int a, final int b) {
        System.out.println(a + b);
    }

    @Override
    public void div(final int a, final int b) {
        System.out.println(a / b);
    }

    @Override
    public void sub(final int a, final int b) {
        System.out.println(a - b);
    }

    @Override
    public void multi(final int a, final int b) {
        System.out.println(a * b);
    }

    @Override
    public boolean check(final int a, final int b) {
        return a != 0 && b != 0 && a + b != 0;
    }

    @Override
    public void info() {
        Calculator.super.info();
    }
}
