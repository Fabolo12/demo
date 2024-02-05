package com.jr.module3.lesson11.bridge.shapes;

import com.jr.module3.lesson11.bridge.colors.Color;

public class Square extends Shape {

    public Square(final Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Square with " + color.fill());
    }
}
