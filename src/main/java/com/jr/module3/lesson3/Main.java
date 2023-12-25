package com.jr.module3.lesson3;

public class Main {
    public static void main(String[] args) {
        final Calculator calculator = new Calculator();
        System.out.println("Sum " + calculator.sum(1, 1));
        System.out.println("Sub " + calculator.sub(1, 1));
        System.out.println("Div " + calculator.div(1, 1));
        System.out.println("Multi " + calculator.multi(1, 1));
    }

}
