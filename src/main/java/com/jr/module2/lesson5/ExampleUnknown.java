package com.jr.module2.lesson5;

interface MyInterface {
    void print(String line);

    default String getStar() {
        return "***";
    }
}

public class ExampleUnknown {
    public static void main(String[] args) {
        final MyInterface myInterface = new MyInterface() {
            @Override
            public void print(final String line) {
                System.out.println(line);
            }
        };

        final MyInterface myInterface2 = new MyInterface() {
            @Override
            public void print(final String line) {
                System.out.println(getStar() + line + getStar());
            }
        };


        myInterface.print("qwerty");
        myInterface2.print("qwerty");

        final MyAbstract myAbstract = new MyAbstract() {
            @Override
            void print(final String line) {
                System.out.println(getStar() + line + getStar());
            }

            @Override
            String getStar() {
                return "*^*";
            }
        };
        myAbstract.print("qwerty");



    }
}

class Unknown implements MyInterface {
    @Override
    public void print(final String line) {

    }
}

abstract class MyAbstract {
    abstract void print(final String line);

    String getStar() {
        return "***";
    }
}

class Unknown2 extends MyAbstract {
    @Override
    void print(final String line) {
        System.out.println(getStar() + line + getStar());
    }
}
