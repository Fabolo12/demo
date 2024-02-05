package com.jr.module3.lesson11.mediator;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        final Mediator mediator = new Mediator();
        new Fan(mediator);
        final Button button = new Button(mediator);
        button.press();
        System.out.println();
        TimeUnit.SECONDS.sleep(2);
        button.press();
    }
}
