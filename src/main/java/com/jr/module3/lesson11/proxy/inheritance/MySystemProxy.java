package com.jr.module3.lesson11.proxy.inheritance;

public class MySystemProxy extends MySystem {
    @Override
    public void operation(final String param) {
        final long start = System.currentTimeMillis();
        super.operation(param);
        final long end = System.currentTimeMillis();
        System.out.println("Duration: " + ((end - start) * 1.0 / 1000));
    }
}
