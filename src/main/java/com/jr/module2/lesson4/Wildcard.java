package com.jr.module2.lesson4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Wildcard {
    public static void main(String[] args) {
        List<? extends Number> list;
        if (new Random().nextBoolean()) {
            list = ints();
        } else {
            list = doubles();
        }

        for (Number number : list) {
            System.out.println(number);
        }


        List<? super Number> list1 = new ArrayList<>();
        ints(list1);
    }

    private static List<Integer> ints() {
        return List.of(1, 2);
    }

    private static List<Double> doubles() {
        return List.of(1.0, 2.0);
    }

    private static void ints(final List<? super Number> integers) {
        integers.add(1);
        integers.add(2);
        integers.add(3);
    }
}
