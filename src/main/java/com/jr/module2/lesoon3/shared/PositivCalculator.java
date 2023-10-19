package com.jr.module2.lesoon3.shared;

class PositivCalculator implements Calculator {
    @Override
    public void sum(final int a, final int b) {
        System.out.println(a + b);
    }

    @Override
    public void div(final int a, final int b) {
        // Nothing to do here
    }

    @Override
    public void sub(final int a, final int b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void multi(final int a, final int b) {
        System.out.println(a * b);
    }
}
