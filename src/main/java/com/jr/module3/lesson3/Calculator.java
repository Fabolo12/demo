package com.jr.module3.lesson3;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Calculator { // ALT + SHIFT + T

    private static int lastResult;

    public static int getLastResult() {
        return lastResult;
    }

    public static void reset() {
        lastResult = 0;
    }

    public int sum(final int a, final int b) {
        lastResult = a + b;
        return lastResult;
    }

    public int sub(final int a, final int b) {
        lastResult = a - b;
        return lastResult;
    }

    public int div(final int a, final int b) {
        if (a == 0) {
            throw new IllegalArgumentException("A mustn't be zero");
        }

        if (b == 0) {
            return 0;
        }

        lastResult = a / b;
        return lastResult;
    }

    public int multi(final int a, final int b) {
        lastResult = a * b;
        return lastResult;
    }


    @SneakyThrows
    public int stuckSum(final int a, final int b) {
        TimeUnit.SECONDS.sleep(2);
        return a + b;
    }
}
