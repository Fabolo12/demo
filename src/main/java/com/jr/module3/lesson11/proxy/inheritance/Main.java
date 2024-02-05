package com.jr.module3.lesson11.proxy.inheritance;

public class Main {
    public static void main(String[] args) {
        final MySystem mySystem = new MySystem();
        mySystem.operation("t");

        final MySystem mySystem2 = new MySystemProxy();
        mySystem2.operation("q");
    }
}
