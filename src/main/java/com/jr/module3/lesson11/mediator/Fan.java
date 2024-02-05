package com.jr.module3.lesson11.mediator;

import lombok.Getter;

@Getter
public class Fan {
    private final Mediator mediator;

    private boolean isOn;


    public Fan(final Mediator mediator) {
        this.mediator = mediator;
        mediator.setFan(this);
    }

    public void turnOn() {
        System.out.println("Fun turn on");
        isOn = true;
        mediator.start();
    }

    public void turnOff() {
        System.out.println("Fun turn off");
        isOn = false;
        mediator.stop();
    }
}
