package com.jr.module3.lesson4;

import lombok.Getter;

@Getter
public enum BookCount {
    ONE(1), TWO(2), ZERO(0);

    private final int count;

    BookCount(final int count) {
        this.count = count;
    }
}
