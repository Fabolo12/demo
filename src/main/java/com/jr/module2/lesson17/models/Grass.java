package com.jr.module2.lesson17.models;

import com.jr.module2.lesson17.config.ConfigLoader;

public class Grass extends Organism {

    private static final String CONFIG_KEY = "grass.";

    @Override
    protected String getConfigKey() {
        return CONFIG_KEY;
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
