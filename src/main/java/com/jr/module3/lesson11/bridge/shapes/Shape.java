package com.jr.module3.lesson11.bridge.shapes;

import com.jr.module3.lesson11.bridge.colors.Color;

public abstract class Shape {
    protected Color color;

    protected Shape(final Color color) {
        this.color = color;
    }

    public abstract void draw();
}
