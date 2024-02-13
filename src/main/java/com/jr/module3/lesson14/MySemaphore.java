package com.jr.module3.lesson14;

import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MySemaphore extends Thread {

    private final Semaphore semaphore;
    private final CommonResource commonResource;

    MySemaphore(final Semaphore semaphore, final CommonResource commonResource) {
        this.semaphore = semaphore;
        this.commonResource = commonResource;
    }

    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(4);
        final CommonResource commonResource = new CommonResource();

        final List<Thread> mySemaphores = List.of(
                new MySemaphore(semaphore, commonResource),
                new MySemaphore(semaphore, commonResource),
                new MySemaphore(semaphore, commonResource),
                new MySemaphore(semaphore, commonResource)
        );

        final long start = System.currentTimeMillis();
        mySemaphores.forEach(Thread::start);
        mySemaphores.forEach(mySemaphore -> {
            try {
                mySemaphore.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        final long end = System.currentTimeMillis();

        System.out.println("CommonResource: " + commonResource.getX());
        System.out.println("CommonResource atomic: " + commonResource.getAtomic());
        System.out.println("Time: " + ((end - start) / 1000));

    }

    @SneakyThrows
    @Override
    public void run() {
        final String name = Thread.currentThread().getName();
        System.out.printf("[%s] Waiting for order\n", name);
        semaphore.acquire();
        System.out.printf("[%s] Start working\n", name);
        for (int i = 0; i < 10_000; i++) {
            commonResource.setX(commonResource.getX() + 1);
            commonResource.increment();
            TimeUnit.MILLISECONDS.sleep(1);
        }
        System.out.printf("[%s] End working\n", name);
        semaphore.release();
    }
}
