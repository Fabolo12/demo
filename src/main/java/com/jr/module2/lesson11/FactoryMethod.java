package com.jr.module2.lesson11;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

enum ProductType {
    BOX, BALL, RECT, TREE
}

interface Product {
    String getName();
}

public class FactoryMethod {
    public static void main(String[] args) {
        final Product product = factoryMethod(ProductType.BOX);
        final Product product1 = factoryMethod2(ProductType.BOX);

        System.out.println(product.getName());
        System.out.println(product1.getName());
    }

    private static Product factoryMethod(ProductType product) {
        if (ProductType.BOX == product) {
            return new Box();
        } else if (ProductType.RECT == product) {
            return new Rec();
        } else if (ProductType.BALL == product) {
            return new Ball();
        } else {
            System.out.println("ERROR, " + product.name());
            throw new IllegalArgumentException(product.name());
        }
    }

    private static Product factoryMethod2(ProductType product) {
        ProductCreator creator;

        if (ProductType.BOX == product) {
            creator = new BoxProductCreator();
        } else if (ProductType.RECT == product) {
            throw new UnsupportedOperationException();
        } else if (ProductType.BALL == product) {
            throw new UnsupportedOperationException();
        } else {
            System.out.println("ERROR, " + product.name());
            throw new IllegalArgumentException(product.name());
        }

        return creator.create();
    }
}

class Box implements Product {
    @Override
    public String getName() {
        return "Box";
    }
}

class Ball implements Product {
    @Override
    public String getName() {
        return "Ball";
    }
}

class Rec implements Product {
    @Override
    public String getName() {
        return "Rec";
    }
}

abstract class ProductCreator {
    private static int id = 10;

    abstract Product create();

    protected int getId() {
        return id++;
    }

}

class BoxProductCreator extends ProductCreator {
    @Override
    Product create() {
        System.out.println(getId() + "Box");
        return new Box();
    }
}