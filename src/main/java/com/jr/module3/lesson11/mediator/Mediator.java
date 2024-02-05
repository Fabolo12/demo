package com.jr.module3.lesson11.mediator;

import lombok.Setter;

@Setter
public class Mediator {
    private Button button;

    private Fan fan;


    public void press() {
        if (fan.isOn()) {
            fan.turnOff();
        } else {
            fan.turnOn();
        }
    }

    public void start() {
        System.out.println("Power start");
    }

    public void stop() {
        System.out.println("Power stop");
    }
}
