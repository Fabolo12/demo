package com.jr.module2.lesson5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExampleCompare {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(1);
        list.add(85);
        list.add(10);
        Collections.sort(list);
        System.out.println(list);

        List<Cat> list2 = new ArrayList<>();
        list2.add(new Cat("q1"));
        list2.add(new Cat("a111"));
        list2.add(new Cat("s11"));
        list2.add(new Cat("w1111"));
        Collections.sort(list2);
        Collections.sort(list2, new CatComparator());
        System.out.println(list2);

        Collections.sort(list2, new Comparator<Cat>() {
            @Override
            public int compare(final Cat o1, final Cat o2) {
                return Integer.compare(o1.name.length(), o2.name.length());
            }
        });

        Collections.sort(list2, (o1, o2) -> Integer.compare(o1.name.length(), o2.name.length()));
        Collections.sort(list2, Comparator.comparingInt(o -> o.name.length()));

    }
}

class CatComparator implements Comparator<Cat> {
    @Override
    public int compare(final Cat o1, final Cat o2) {
        return Integer.compare(o1.name.length(), o2.name.length());
    }
}


