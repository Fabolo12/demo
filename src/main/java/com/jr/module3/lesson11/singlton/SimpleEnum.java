package com.jr.module3.lesson11.singlton;

public enum SimpleEnum {
    INSTANCE;

    private String field = "SimpleEnum";

    public void print() {
        System.out.println(field);
    }
}
