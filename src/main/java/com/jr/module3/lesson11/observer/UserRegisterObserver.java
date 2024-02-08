package com.jr.module3.lesson11.observer;

public class UserRegisterObserver implements Observer {
    @Override
    public void update(final Event event) {
        System.out.println("User info: " + event.data());
    }

    @Override
    public boolean isApplicable(final Event event) {
        return true;
    }
}
