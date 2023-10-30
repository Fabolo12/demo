package com.jr.module2.lesson6.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        final List<String> lines = List.of("q2", "132w", "13123e", "r124123412", "t321");
        final List<String> newLines = new ArrayList<>();

        for (String line : lines) {
            if (line.length() <= 4) {
                newLines.add(line);
            }
        }
        System.out.println(newLines);

        final List<Integer> list = lines.stream()
                .filter(s -> s.length() <= 4)
                .limit(10)
                .map(s -> s.length())
                .peek(s -> System.out.println("***" + s + "***"))
                .sorted(((o1, o2) -> Integer.compare(o2, o1)))
                .distinct()
                .skip(0)
                .toList();
        System.out.println(list);
        System.out.println(lines);

        final Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        final IntStream intStream = integerStream.mapToInt(x -> x);

//        intStream.sum();
//        intStream.average();
//        intStream.count();
//        intStream.max();
//        intStream.min();
//        intStream.mapToObj(x -> new AbstractMap.SimpleEntry<>(x, LocalDate.now()));
//        final Stream<Integer> boxed = intStream.boxed();
        final IntSummaryStatistics intSummaryStatistics = intStream.summaryStatistics();
        System.out.println(intSummaryStatistics);

        final Item item1 = new Item("Item1");
        final Box box1 = new Box(10, List.of(item1));


        final Item item2 = new Item("Item2");
        final Item item3 = new Item("Item3");
        final Box box2 = new Box(15, List.of(item2, item3));

        final List<Box> boxes = List.of(box1, box2);

        boxes.stream()
                .filter(box -> box.size >= 10)
                .flatMap(box -> box.items.stream())
                .filter(item -> item.name.endsWith("2") || item.name.endsWith("3"))
                .forEach(item -> System.out.println(item));

        // map peek mapToInt flatMap

//        boxes.stream().collect(Collectors.groupingBy());
        boxes.stream().toList();
        boxes.stream().collect(Collectors.toSet());
        boxes.stream()
                .map(box -> box.toString())
                .collect(Collectors.joining(","));
        boxes.stream().anyMatch(box -> box.size == 10); // true
        boxes.stream().allMatch(box -> box.size == 10); // false
        boxes.stream().noneMatch(box -> box.size == 10); // false

        final Optional<Box> first = boxes.stream().findFirst();
        final Optional<Box> any = boxes.stream().findAny();

        final Map<Box, Integer> map = boxes.stream()
                .collect(Collectors.toMap(x -> x, x -> x.size));

        map.keySet().stream();
        map.values().stream();
        map.entrySet().stream();

        map.values().stream()
                .map(x -> mapMyInteger(x))
                .map(Main::mapMyInteger)
                .forEach(System.out::println);
    }

    private static Integer mapMyInteger(final Integer number) {
        return number * 10;
    }


    private Stream<Object> getStream() {
        if (new Random().nextBoolean()) {
            return Stream.of(new Object());
        }

        return Stream.empty();
    }

    private List<Object> getList() {
        if (new Random().nextBoolean()) {
            return List.of(new Object());
        }

        return Collections.emptyList();
    }
}


class Box {
    public int size;

    public List<Item> items;

    Box(final int size, final List<Item> items) {
        this.size = size;
        this.items = items;
    }
}

class Item {
    public String name;

    Item(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}