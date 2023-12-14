package com.jr.module2.lesson17.models;

public abstract class Organism {
    public abstract int getWeight();
    public abstract int getMaxCount();

    protected final String WEIGHT_CONFIG_KEY = getConfigKey() + "weight";
    protected final String MAX_COUNT_CONFIG_KEY = getConfigKey() + "max-count";

    protected abstract String getConfigKey();
}
