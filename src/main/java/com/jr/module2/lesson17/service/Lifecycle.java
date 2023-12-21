package com.jr.module2.lesson17.service;

import com.jr.module2.lesson17.config.ConfigLoader;
import com.jr.module2.lesson17.models.Animal;
import com.jr.module2.lesson17.models.AnimalType;
import com.jr.module2.lesson17.models.Map;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Lifecycle {

    private static final String CONFIG_KEY = "general.lifecycle.";
    private static final Random RANDOM = new Random();


    private final ExecutorService executor;

    private final LogService logService;

    public Lifecycle() {
        executor = Executors.newFixedThreadPool(2);
        logService = new LogService();
    }

    public void life() throws InterruptedException, ExecutionException {
        initLife();
        logService.logInfo();
        System.out.println("INIT COMPLETED");

        while (true) {
            final Future<?> submitAnimalCycle = executor.submit(new AnimalCycle());
            final Future<?> submitGrassCycle = executor.submit(new GrassCycle());
            TimeUnit.MILLISECONDS.sleep(ConfigLoader.getIntegerProperty(CONFIG_KEY + "wait-time"));
            submitAnimalCycle.get();
            submitGrassCycle.get();
            logService.logInfo();
        }
    }

    private void initLife() {
        initAnimals();
        initGrass();
    }

    private void initAnimals() {
        final AnimalType[] values = AnimalType.values();
        final int basicAnimalCount = ConfigLoader.getIntegerProperty(CONFIG_KEY + "basic-animal-count");
        final int basicAnimalCountPerType = basicAnimalCount / values.length;
        for (AnimalType type : values) {
            initOrganism(basicAnimalCountPerType, type);
        }
    }

    private void initGrass() {
        final int basicGrassCount = ConfigLoader.getIntegerProperty(CONFIG_KEY + "basic-grass-count");
        initOrganism(basicGrassCount, null);
    }

    private void initOrganism(final int basicCount, final AnimalType type) {
        final Map map = Map.getInstance();
        int count = 0;
        int tryCount = 0;
        final int height = map.getHeight();
        final int width = map.getWidth();
        final int maxTryCount =  height * width / 2;

        do {
            final int tempHeight = RANDOM.nextInt(0, height);
            final int tempWidth = RANDOM.nextInt(0, width);
            final boolean isAdd;

            if (type != null) {
                final Animal animal = type.createAnimal();
                isAdd = map.addAnimal(animal, tempHeight, tempWidth);
            } else {
                isAdd = map.addGrass(tempHeight, tempWidth);
            }

            if (isAdd) {
                count++;
            } else {
                tryCount++;
            }

        } while (count < basicCount && tryCount < maxTryCount);
    }

}
