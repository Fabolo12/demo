package com.jr.module3.lesson11.mediator;

public class Button {
    private final Mediator mediator;


    public Button(final Mediator mediator) {
        this.mediator = mediator;
        mediator.setButton(this);
    }

    public void press() {
        System.out.println("Button click");
        mediator.press();
    }
}
