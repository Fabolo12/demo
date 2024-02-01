package com.jr.module3.lesson11.singlton;

public class Main {
    public static void main(String[] args) {
        Simple.getInstance().print();
        SimplePlusLazyLoad.getInstance().print();
        SimpleEnum.INSTANCE.print();
    }
}
