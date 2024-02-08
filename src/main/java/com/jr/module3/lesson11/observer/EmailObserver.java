package com.jr.module3.lesson11.observer;

public class EmailObserver implements Observer{
    @Override
    public void update(final Event event) {
        System.out.println("Send email to: " + event.data());
    }

    @Override
    public boolean isApplicable(final Event event) {
        return "email".equalsIgnoreCase(event.type());
    }
}
