package com.jr.module3.lesson11.observer;

public interface Observer {
    void update(Event event);

    boolean isApplicable(Event event);
}
