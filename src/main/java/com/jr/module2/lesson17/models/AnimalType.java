package com.jr.module2.lesson17.models;

public enum AnimalType {
    WOLF(Wolf.class),
    HORSE(Horse.class);

    private final Class<? extends Animal> aClass;

    AnimalType(final Class<? extends Animal> aClass) {
        this.aClass = aClass;
    }

    public Animal createAnimal() {
        try {
            return aClass.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
