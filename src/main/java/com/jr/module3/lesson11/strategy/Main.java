package com.jr.module3.lesson11.strategy;

public class Main {
    public static void main(String[] args) {
        final Calc calc = new Calc();
        calc.setOperation(new SubOperation());
        System.out.println("SubOperation 10, 5 = " + calc.operation(10, 5));
        calc.setOperation(new DivOperation());
        System.out.println("DivOperation 10, 5 = " + calc.operation(10, 5));
        calc.setOperation(new MultOperation());
        System.out.println("MultOperation 10, 5 = " + calc.operation(10, 5));
        calc.setOperation(new SumOperation());
        System.out.println("SumOperation 10, 5 = " + calc.operation(10, 5));
    }
}
