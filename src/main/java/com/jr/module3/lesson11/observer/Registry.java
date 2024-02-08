package com.jr.module3.lesson11.observer;

import java.util.HashSet;
import java.util.Set;

public class Registry {
    private final Set<Observer> observers = new HashSet<>();

    public void addObserver(final Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(final Observer observer) {
        observers.remove(observer);
    }

    public void postEvent(final Event event) {
        observers.stream()
                .filter(observer -> observer.isApplicable(event))
                .forEach(observer -> observer.update(event));
    }
}
