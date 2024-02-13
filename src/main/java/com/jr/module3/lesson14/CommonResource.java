package com.jr.module3.lesson14;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class CommonResource {
    private int x = 0;
    private AtomicInteger atomic = new AtomicInteger(0);


    public void increment() {
        atomic.incrementAndGet();
    }
}
