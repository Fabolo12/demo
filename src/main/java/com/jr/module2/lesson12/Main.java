package com.jr.module2.lesson12;

public class Main {
    public static void main(String[] args) {
        final OuterClass outerClass = new OuterClass();
        final OuterClass.InnerClass innerClass1 = outerClass.new InnerClass();
        final OuterClass.InnerClass innerClass2 = new OuterClass().new InnerClass();

        final var innerClassTwo1 = innerClass2.new InnerClassTwo();
        final var innerClassTwo2 = new OuterClass().new InnerClass().new InnerClassTwo();

        final OuterClass.InnerStaticClass innerClass = new OuterClass.InnerStaticClass();

        String a = "";
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(a);
            }
        };
    }
}


class OuterClass {
    String name;

    private int age;

//    public int getInnerClassAge() {
//        return age2;
//    }

    public InnerClass create() {
        return new InnerClass();
    }

//    public static InnerClass create2() {
//        return new InnerClass();
//    }
    
    class InnerClass {
        String address;

        static String city;

        private int age2;

        public void print() {
            String address = "";
            String city = "";
            String name = "";
            System.out.println(address + " " + name + city);
            System.out.println(this.address);
            System.out.println(InnerClass.city);
            System.out.println(OuterClass.this.name);
        }

        public int getOuterClassAge() {
            return age;
        }

        class InnerClassTwo {

        }
    }

    static class InnerStaticClass {

    }
}