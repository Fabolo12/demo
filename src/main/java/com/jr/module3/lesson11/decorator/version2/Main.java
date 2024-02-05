package com.jr.module3.lesson11.decorator.version2;

interface Shape {
    void draw();
}


class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}

abstract class ShapeDecorator implements Shape {

    protected Shape decoratedShape;

    protected ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }
}

class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}

public class Main {
    public static void main(String[] args) {

        final Rectangle rectangle = new Rectangle();
        System.out.println("Rectangle with normal border");
        rectangle.draw();


        Shape redRectangle = new RedShapeDecorator(rectangle);
        System.out.println("Rectangle of red border");
        redRectangle.draw();
    }
}