package com.jr.module2.lesson5;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@FunctionalInterface
interface MyComparator {
    int compare(Cat cat1, Cat cat2);
}

@FunctionalInterface
interface MyInterfaceEmpty {
    void method();
}

@FunctionalInterface
interface MyInterfaceReturnInt {
    int method(int a);

    default int method2() {
        return 10;
    }

    static int method3() {
        return 10;
    }
}

@FunctionalInterface
interface MyInterfaceReturnIntSecond {
    int method(int a, int b);
}

@FunctionalInterface
interface MyInterfaceCreate {
    Cat method();
}

public class ExampleLambda {
    public static void main(String[] args) {
        final MyComparator comparator0 = new MyComparator() {
            @Override
            public int compare(final Cat cat1, final Cat cat2) {
                return Integer.compare(cat1.name.length(), cat2.name.length());
            }
        };

        final MyComparator comparator1 = (cat1, cat2) -> Integer.compare(cat1.name.length(), cat2.name.length());

        final MyInterfaceEmpty empty = () -> System.out.println("qwerty");
        empty.method();

        final MyInterfaceEmpty empty2 = () -> {
            final LocalDate now = LocalDate.now();
            System.out.println(now);
        };
        empty2.method();

        final MyInterfaceReturnInt returnInt = number -> 0;
        System.out.println(returnInt.method(15));

        final MyInterfaceReturnIntSecond returnIntSecond = (number1, number2) -> 0;

        final MyInterfaceReturnInt returnInt2 = number -> {
            System.out.println(MyInterfaceReturnInt.method3());
            final int newNumber = number * 10;
            return newNumber;
        };
        System.out.println(returnInt2.method(5));
        System.out.println(returnInt2.method2());

        final int userInput = 100;

        final MyInterfaceReturnInt returnInt3 = number -> {
            int delta = 1;
            delta = delta + 1;
            final int newNumber = number * userInput + delta;
            return newNumber;
        };
        System.out.println(returnInt3.method(5));

        int newUserInput = userInput + 1;

        final MyInterfaceCreate create = () -> new Cat();
        final MyInterfaceCreate create2 = Cat::new;
        System.out.println(create2.method());

        final MyInterfaceReturnInt returnInt4 = ExampleLambda::methodLink;
        final MyInterfaceReturnInt returnInt5 = a -> methodLink(a);
        System.out.println(returnInt4.method(10));

        final MyInterfaceReturnInt returnInt6 = a -> methodLink(a + 1);
        final MyInterfaceReturnInt returnInt7 = a -> methodLink(a, 50);

        Predicate<String> predicate = String::isEmpty;
        System.out.println("Line is empty: " + predicate.test(""));
        System.out.println("Line is empty: " + predicate.test("qwerty"));

        Consumer<String> consumer = line -> System.out.println("***" + line + "***");
        consumer.accept("qwerty");

        Function<String, Integer> function = String::length;
        System.out.println("Length: " + function.apply("qwerty"));

        Supplier<String> supplier = () -> "qwerty";
        System.out.println(supplier.get());

        UnaryOperator<String> unaryOperator = line -> "***" + line + "***";
        System.out.println(unaryOperator.apply("qwerty"));
    }

    private static int methodLink(final int a) {
        return a * 10 - 50;
    }

    private static int methodLink(final int a, final int b) {
        return a * 10 - b;
    }
}

class CatComparator1 implements MyComparator {
    @Override
    public int compare(final Cat cat1, final Cat cat2) {
        return Integer.compare(cat1.name.length(), cat2.name.length());
    }
}