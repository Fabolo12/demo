package com.jr.module3.lesson11.bridge.shapes;

import com.jr.module3.lesson11.bridge.colors.Color;

public class Box extends Shape {
    public Box(final Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Box with " + color.fill());
    }
}
