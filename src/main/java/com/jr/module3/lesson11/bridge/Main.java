package com.jr.module3.lesson11.bridge;

import com.jr.module3.lesson11.bridge.colors.Blue;
import com.jr.module3.lesson11.bridge.colors.Color;
import com.jr.module3.lesson11.bridge.colors.Green;
import com.jr.module3.lesson11.bridge.shapes.Box;
import com.jr.module3.lesson11.bridge.shapes.Shape;
import com.jr.module3.lesson11.bridge.shapes.Square;

public class Main {
    public static void main(String[] args) {
        final Color blue = new Blue();
        final Color green = new Green();

        final Shape box0 = new Box(blue);
        box0.draw();
        final Shape box1 = new Box(green);
        box1.draw();
        final Shape square0 = new Square(green);
        square0.draw();
        final Shape square1 = new Square(blue);
        square1.draw();
    }
}
