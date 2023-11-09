package com.jr.module2.lesson9;

import java.util.concurrent.TimeUnit;

public class ThreadExample {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        final MyThread myThread = new MyThread();
        /*new Thread(new MyThread2()).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }).start();*/
//        myThread.setDaemon(true);
        myThread.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End program");
//        myThread.stop();
        myThread.interrupt();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);

        }
        if (!Thread.currentThread().isInterrupted()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Thread.interrupted();
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}