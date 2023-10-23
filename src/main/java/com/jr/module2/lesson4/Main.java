package com.jr.module2.lesson4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Calculator<Integer> integerCalculator = new Calculator<>();
        System.out.println(integerCalculator.sum(1, 2));

        final Calculator<Double> doubleCalculator = new Calculator<>();
        System.out.println(doubleCalculator.sum(1.0, 2.0));

        new Zoo().print1("123");
        new Zoo().print1(123L);
        Zoo.print2("123");
        Zoo.print2(123);

        final Pair<Integer, String> pair1 = new Pair<>(1, "1");
        final Pair<String, Integer> pair2 = new Pair<>("1", 1);
        final Triple<Integer, Integer, Integer> triple = new Triple<>(1, 1, 1);
        final StringKeyValue<Integer> stringKeyValue = new StringKeyValue<>("1", 1);
        final StringInteger stringInteger = new StringInteger("1", 1);
        Pair<String, Integer> pair = stringInteger;

        List<StringInteger> list1 = new ArrayList<>();
//        List<Pair> list2 = list1;


    }



}
