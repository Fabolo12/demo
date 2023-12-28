package com.jr.module3.lesson4;

import java.util.Random;

public class BookRepository {
    public int getAllBooks() {
        return new Random().nextInt();
    }

    public void save() {

    }

    public String save(final Integer count) {
        return "";
    }

    public String save(final Integer count, final Integer delta) {
        return "";
    }

    String throwException() {
        throw new UnsupportedOperationException();
    }
}
