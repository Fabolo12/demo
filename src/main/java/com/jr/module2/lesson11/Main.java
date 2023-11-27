package com.jr.module2.lesson11;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        /*final ThreadGroup threadGroup = new ThreadGroup("MyGroup");
        new Thread(threadGroup, new MyThread()).start();
        new Thread(threadGroup, new MyThread()).start();
        new Thread(threadGroup, new MyThread()).start();
        System.out.println(threadGroup.activeCount());
        System.out.println(threadGroup.getName());*/

        final ExecutorService executorService = Executors.newFixedThreadPool(10);

        Runnable runnable = () -> {
            System.out.println("Runnable task");
        };

        Callable<String> callable = () -> {
            System.out.println("Callable task");
            return "Callable answer";
        };

        List<Callable<String>> list = List.of(callable, callable, callable);

        executorService.execute(runnable);
        final Future<String> answerFuture = executorService.submit(callable);
        while (!answerFuture.isDone()) {
            System.out.println(answerFuture.get());
        }

        final String s = answerFuture.get(10, TimeUnit.SECONDS);

        executorService.invokeAll(list);
        executorService.invokeAny(list);

        executorService.shutdown();
        if (executorService.awaitTermination(800, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class MyThread2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return null;
    }
}