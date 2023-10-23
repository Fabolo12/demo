package com.jr.module2.lesson4;

public class MyList<R> {
    private R lastElement;

    private R[] elements;

    MyList(final R lastElement) {
        this.lastElement = lastElement;
    }

    public void add(final R element) {
        lastElement = element;
    }

    public R getLastElement() {
        return lastElement;
    }
}

class MyListString {
    private String lastElement;

    private String[] elements;

    MyListString(final String lastElement) {
        this.lastElement = lastElement;
    }

    public void add(final String element) {
        lastElement = element;
    }

    public String getLastElement() {
        return lastElement;
    }
}
