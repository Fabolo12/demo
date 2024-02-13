package com.jr.module3.lesson14;

import lombok.SneakyThrows;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class MyCyclicBarrier extends Thread {
    private final CyclicBarrier cyclicBarrier;
    private final Random random = new Random();

    MyCyclicBarrier(final CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @SneakyThrows
    public static void main(String[] args) {
        final CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("~~TEST~~"));

        final List<Thread> mySemaphores = List.of(
                new MyCyclicBarrier(barrier),
                new MyCyclicBarrier(barrier),
                new MyCyclicBarrier(barrier)
        );

        mySemaphores.forEach(Thread::start);
    }

    @SneakyThrows
    @Override
    public void run() {
        final String name = Thread.currentThread().getName();
        final int i = random.nextInt(1000);
        System.out.printf("[%s] waiting: %d\n", name, i);
        TimeUnit.MILLISECONDS.sleep(i);
        cyclicBarrier.await();
        System.out.printf("[%s] end\n", name);
    }
}
