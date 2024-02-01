package com.jr.module3.lesson11.singlton;

public class Simple {

    private String field = "Simple";

    private static final Simple SIMPLE = new Simple();

    private Simple() {
    }

    public static Simple getInstance() {
        return SIMPLE;
    }

    public void print() {
        System.out.println(field);
    }

}
