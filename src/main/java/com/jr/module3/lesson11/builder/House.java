package com.jr.module3.lesson11.builder;

import lombok.ToString;

@ToString
public class House {
    private int field1;
    private int field2;
    private int field3;
    private String field4;
    private String field5;

    private House() {
    }

    public static class Builder {
        private int field1;
        private int field2;
        private int field3;
        private String field4;
        private String field5;

        public Builder withField1(final int field1) {
            if (field1 == 0) {
                throw new IllegalArgumentException();
            }
            this.field1 = field1;
            return this;
        }

        public Builder withField2(final int field2) {
            this.field2 = field2;
            return this;
        }

        public Builder withField3(final int field3) {
            this.field3 = field3;
            return this;
        }

        public Builder withField4(final String field4) {
            this.field4 = field4;
            return this;
        }

        public Builder withField5(final String field5) {
            this.field5 = field5;
            return this;
        }

        public House build() {
            if (field5 == null) {
                throw new IllegalStateException("field5");
            }
            final House house = new House();
            house.field1 = field1;
            house.field2 = field2;
            house.field3 = field3;
            house.field4 = field4;
            house.field5 = field5;
            return house;
        }
    }
}
