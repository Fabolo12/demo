package com.jr.module3.lesson7;

public record User(String id, String name) {

    public User(final String name) {
        this(null, name);
    }
}