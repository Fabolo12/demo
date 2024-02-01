package com.jr.module3.lesson11.adapter;

public class AdapterExtImpl implements Adapter {

    private final MySystem system;

    AdapterExtImpl(final MySystem system) {
        this.system = system;
    }

    @Override
    public void print() {
        System.out.println("****");
        System.out.println(system.create());
        System.out.println("****");
    }
}
