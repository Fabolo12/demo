package com.jr.module3.lesson11.observer;

public class Main {
    public static void main(String[] args) {
        final Registry registry = new Registry();
        registry.addObserver(new EmailObserver());
        registry.addObserver(new UserRegisterObserver());

        final Event event1 = new Event("USER", "TEST");
        final Event event2 = new Event("EMAIL", "TEST");
        registry.postEvent(event1);
        registry.postEvent(event2);
    }
}
