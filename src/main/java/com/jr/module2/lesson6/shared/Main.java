package com.jr.module2.lesson6.shared;

enum AnimalType {
    DOG
}

interface Eater {

}

interface Eater2 {

}

public class Main {
    public static void main(String[] args) {
        final Dog dog = new Dog();
        final Animal dogObject = new Dog();

        System.out.println("Dog " + (dog instanceof Dog));
        System.out.println("Dog " + (dogObject instanceof Dog));
        System.out.println("Animal " + (dogObject instanceof Animal));
        System.out.println("Object " + (dogObject instanceof Object));
        System.out.println("Eater " + (dogObject instanceof Eater));
        System.out.println("Eater2 " + (dogObject instanceof Eater2));
        System.out.println("AnimalType " + (dogObject.type == AnimalType.DOG));

        if (dogObject instanceof Dog) {
            Dog dog1 = (Dog) dogObject;
            dog1.sleap();
        }

        if (dogObject instanceof Dog dog1) {
            dog1.sleap();
        }

        int number = 5;
        int newNumber = -1;

        switch (number) {
            case 5: {
                System.out.println("5");
                newNumber = 5;
            }
            case 10: {
                System.out.println("10");
                newNumber = 10;
                break;
            }
            case 15: {
                System.out.println(15);
                newNumber = 15;
            }
        }

        switch (number) {
            case 5, 10 -> {
                System.out.println("5");
                System.out.println("10");
            }
            case 15 -> System.out.println(15);
        }

        newNumber = switch (number) {
            case 5, 10 -> {
                System.out.println("5");
                System.out.println("10");
                yield 10;
            }
            case 15 -> {
                System.out.println(15);
                yield 15;
            }
            default -> throw new IllegalStateException("Unexpected value: " + number);
        };

        if (newNumber == 10) {
            System.out.println(10);
        }
        System.out.println(15);

    }
}

class Dog extends Animal implements Eater {
    Dog() {
        super(AnimalType.DOG);
    }

    public void sleap() {
        System.out.println("Zzzz...");
    }
}

class Animal implements Eater2 {
    public AnimalType type;

    Animal(final AnimalType type) {
        this.type = type;
    }
}