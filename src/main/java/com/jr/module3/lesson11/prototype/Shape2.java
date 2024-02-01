package com.jr.module3.lesson11.prototype;

public class Shape2 {
    private int x;

    private int y;

    private Shape2(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public Shape2() {
    }

    public Shape2 copy() {
        return new Shape2(this.x, this.y);
    }
}
