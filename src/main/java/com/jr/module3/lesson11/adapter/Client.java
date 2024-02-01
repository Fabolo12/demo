package com.jr.module3.lesson11.adapter;

public class Client {
    public static void main(String[] args) {
        final MySystem mySystem = new MySystem();
        createAdapter(mySystem).print();
        System.out.println();
        createAdapterExt(mySystem).print();
    }

    private static Adapter createAdapter(final MySystem system) {
        return new AdapterImpl(system);
    }

    private static Adapter createAdapterExt(final MySystem system) {
        return new AdapterExtImpl(system);
    }
}
