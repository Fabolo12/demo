package com.jr.module2.lesson10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private final Object monitor1 = new Object();
    private final Object monitor2 = new Object();

    transient Object object1  = new Object();

    volatile Object object2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        final Resource resource1 = new Resource();
        final Resource resource2 = new Resource();
        final Thread thread1 = new Thread(new MyThread(resource1));
        thread1.start();

        final Thread thread2 = new Thread(new MyThread(resource1));
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(resource1.getCount());
        System.out.println(resource2.getCount());

        int a = 1;
        int b = 2;
        int c = a + b;

        double a1 = 1;
        double b1 = 2;
        double c1 = a1 + b1;

        AtomicInteger integer = new AtomicInteger();
        final int i = integer.addAndGet(1);

        final AtomicInteger sum = new AtomicInteger(0);
        final int[] sum1 = new int[] {0};
        final List<Integer> sum2 = new ArrayList<>();
        List.of(1,2,3,4).forEach(n -> sum.addAndGet(n));
        System.out.println(sum);

    }

    private static synchronized void method1() {

    }

    private synchronized void method2() {

    }

    private void method3() {
        System.out.println(11323);
        synchronized (this) {

        }
        System.out.println(11323);
    }

    private void method4() {
        System.out.println(11323);
        synchronized (Main.class) {

        }
        System.out.println(11323);
    }

    private void method5() {
        System.out.println(11323);
        synchronized (monitor1) {

        }
        synchronized (monitor2) {

        }
        System.out.println(11323);
    }
}

class Resource {
    private int count;

    public synchronized void plus() {
        count++;
    }

    int getCount() {
        return count;
    }
}

class MyThread implements Runnable {
    Resource resource;

    MyThread(final Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            resource.plus();
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Monitor {
    boolean isBlock;
    Thread thread;

    Set<Thread> blockedSet;
    Set<Thread> waitingSet;
}

class MyObject {
    Monitor monitor;
}

class Client {
    void printMessage(List<String> messages) {
        if (messages.isEmpty()) {
            Thread.yield();
        }
    }
}

class JoinExample {
    public static void main(String[] args) {
        Set<Thread> threads = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            threads.add(new Loop());
        }
        threads.forEach(Thread::start);
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(Thread.currentThread().getName());
    }

    static class Loop extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}