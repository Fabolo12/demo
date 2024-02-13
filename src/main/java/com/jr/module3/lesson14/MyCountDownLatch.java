package com.jr.module3.lesson14;

import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MyCountDownLatch extends Thread {
    private final CountDownLatch downLatch;

    MyCountDownLatch(final CountDownLatch downLatch) {
        this.downLatch = downLatch;
    }

    @SneakyThrows
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(150);

        final List<Thread> mySemaphores = List.of(
                new MyCountDownLatch(countDownLatch),
                new MyCountDownLatch(countDownLatch)
        );


        System.out.println("~~~~~~Main start~~~~~~");
        mySemaphores.forEach(Thread::start);
        countDownLatch.await();
        System.out.println("~~~~~~Main end~~~~~~");
    }

    @SneakyThrows
    @Override
    public void run() {
        final String name = Thread.currentThread().getName();

        for (int i = 0; i < 100; i++) {
            System.out.printf("[%s] %d\n", name, i);
            TimeUnit.MILLISECONDS.sleep(1);
            downLatch.countDown();
        }
    }
}
