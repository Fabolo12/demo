package com.jr.module2.lesson17.models;

import com.jr.module2.lesson17.config.ConfigLoader;

public class Horse extends Herbivores {

    private static final String CONFIG_KEY = "animal.herbivores.horse.";

    @Override
    public String getConfigKey() {
        return CONFIG_KEY;
    }

    @Override
    public void reproduce() {

    }

    @Override
    public void chooseDirection() {

    }

    @Override
    public void move() {

    }

    @Override
    public int getWeight() {
        return ConfigLoader.getIntegerProperty(WEIGHT_CONFIG_KEY);
    }

    @Override
    public int getMaxCount() {
        return ConfigLoader.getIntegerProperty(MAX_COUNT_CONFIG_KEY);
    }
}
