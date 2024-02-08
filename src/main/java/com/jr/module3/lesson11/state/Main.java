package com.jr.module3.lesson11.state;

public class Main {
    public static void main(String[] args) {
        Package pkg = new Package(new OrderedState());

        pkg.printStatus();

        pkg.previousState();
        pkg.nextState();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();
    }
}
