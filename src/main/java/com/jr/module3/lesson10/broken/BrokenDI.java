package com.jr.module3.lesson10.broken;

public class BrokenDI {
    private String field1;

    private String field2;

    private String field3;

    private String field4;

    private String field5;

    private String field6;

    private String field7;

    private String field8;

    BrokenDI(
            final String field1,
            final String field2,
            final String field3,
            final String field4,
            final String field5,
            final String field6,
            final String field7,
            final String field8
    ) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
        this.field6 = field6;
        this.field7 = field7;
        this.field8 = field8;
    }

    void setField1(final String field1) {
        this.field1 = field1;
    }
}
