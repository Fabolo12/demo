package com.jr.module2.lesson17.models;

import com.jr.module2.lesson17.config.ConfigLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map {
    private static final String CONFIG_KEY = "general.map.";

    private static Map instance;

    private final Cell[][] map;

    private final int height;

    private final int width;

    private final int maxAnimalLoad;
    private final int maxGrassLoad;

    private Map() {
        height = ConfigLoader.getIntegerProperty(CONFIG_KEY + "height");
        width = ConfigLoader.getIntegerProperty(CONFIG_KEY + "width");
        maxAnimalLoad = ConfigLoader.getIntegerProperty(CONFIG_KEY + "animal.load");
        maxGrassLoad = ConfigLoader.getIntegerProperty(CONFIG_KEY + "grass.load");
        map = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = new Cell();
            }
        }
    }

    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean addAnimal(final Animal animal, final int height, final int width) {
        final Cell cell = map[height][width];

        if (isAllowedAdd(cell.animalLoad, animal.getWeight(), maxAnimalLoad)) {
            cell.animals.add(animal);
            cell.animalLoad += animal.getWeight();
            return true;
        }

        return false;
    }

    public boolean addGrass(final int height, final int width) {
        final Cell cell = map[height][width];
        final Grass grass = new Grass();

        if (isAllowedAdd(cell.grassLoad, grass.getWeight(), maxGrassLoad)) {
            cell.grasses.add(grass);
            cell.grassLoad += grass.getWeight();
            return true;
        }

        return false;
    }

    private boolean isAllowedAdd(final int existValue, final int newValue, final int capacity) {
        return existValue + newValue <= capacity;
    }

    public Cell getCell(final int height, final int width) {
        return map[height][width];
    }

    public class Cell {
        private final List<Animal> animals = new ArrayList<>();
        private final List<Grass> grasses = new ArrayList<>();

        private int animalLoad = 0;

        private int grassLoad = 0;

        public List<Animal> getAnimals() {
            return animals;
        }

        public List<Grass> getGrasses() {
            return grasses;
        }

        public int getAnimalLoad() {
            return animalLoad;
        }

        public int getGrassLoad() {
            return grassLoad;
        }
    }
}
