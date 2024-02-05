package com.jr.module3.lesson11.proxy.interfaces;

public class Main {
    public static void main(String[] args) {
        ExpensiveObject object = new ExpensiveObjectProxy();
        object.process();
        object.process();


    }
}
