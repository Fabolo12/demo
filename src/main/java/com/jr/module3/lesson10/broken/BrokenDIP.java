package com.jr.module3.lesson10.broken;

import java.util.ArrayList;
import java.util.List;

public class BrokenDIP {
    public static void main(String[] args) {
        final List<Object> objects = new ArrayList<>();
        objects.stream()
                .map(o -> {
                    if (o == null) {
                        try {
                            throw new Exception();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    return o;
                })
                .forEach(System.out::println);
    }
}
