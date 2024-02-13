package com.jr.module3.lesson14;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class MyExchanger {
    public static void main(String[] args) {
        final Exchanger<StringBuilder> exchanger = new Exchanger<>();
        new MakeString(exchanger).start();
        new UseString(exchanger).start();
    }
}

class MakeString extends Thread {
    private final Exchanger<StringBuilder> exchanger;

    private final Random random = new Random();

    MakeString(final Exchanger<StringBuilder> exchanger) {
        this.exchanger = exchanger;
    }

    @SneakyThrows
    @Override
    public void run() {
        final String name = Thread.currentThread().getName();
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                line.append((char) random.nextInt(100));
                TimeUnit.MILLISECONDS.sleep(100);
            }
            System.out.printf("[%s] send: %s\n", name, line);
            line = exchanger.exchange(line);
            System.out.printf("[%s] receive: %s\n", name, line);
        }
    }
}

class UseString extends Thread {
    private final Exchanger<StringBuilder> exchanger;

    UseString(final Exchanger<StringBuilder> exchanger) {
        this.exchanger = exchanger;
    }

    @SneakyThrows
    @Override
    public void run() {
        final String name = Thread.currentThread().getName();
        for (int i = 0; i < 3; i++) {
            final StringBuilder line = exchanger.exchange(new StringBuilder());
            System.out.printf("[%s] receive: %s\n", name, line);
        }
    }
}
