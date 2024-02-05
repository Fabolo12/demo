package com.jr.module3.lesson11.proxy.inheritance;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class MySystem {
    @SneakyThrows
    public void operation(final String param) {
        System.out.println("PARAM: " + param);
        TimeUnit.SECONDS.sleep(2);
    }
}
