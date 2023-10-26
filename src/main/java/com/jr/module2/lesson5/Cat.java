package com.jr.module2.lesson5;

public class Cat implements Comparable<Cat> {
    final String name;

    public Cat() {
        name = "";
    }

    Cat(final String name) {
        this.name = name;
    }

    public void method1() {

    }

    void method2() {

    }

    protected void method3() {

    }

    @Override
    public int compareTo(final Cat o) {
        return Integer.compare(name.length(), o.name.length());
    }

    public NameGetter getName() {
        return this::getNameLink;
    }

    private String getNameLink() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}

interface NameGetter {
    String getName();
}
