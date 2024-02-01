package com.jr.module3.lesson11.builder;

public class Problem {
    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;

    Problem(final String field1) {
        this.field1 = field1;
    }

    Problem(final String field1, final String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    Problem(final String field1, final String field2, final String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    Problem(final String field1, final String field2, final String field3, final String field4) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
    }

    Problem(final String field1, final String field2, final String field3, final String field4, final String field5) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
    }
}
