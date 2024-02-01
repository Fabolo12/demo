package com.jr.module3.lesson11.adapter;

public class AdapterImpl implements Adapter {

    private final MySystem system;

    AdapterImpl(final MySystem system) {
        this.system = system;
    }

    @Override
    public void print() {
        System.out.println("Not json");
        System.out.println(system.create());
    }
}
