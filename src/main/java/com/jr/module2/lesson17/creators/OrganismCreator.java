package com.jr.module2.lesson17.creators;

import com.jr.module2.lesson17.models.Organism;

public abstract class OrganismCreator {
    public Organism create() {
        final Organism organism = createSpecific();
        System.out.printf("Created organism with Weight %06d and MaxCount %d%n",
                organism.getWeight(), organism.getMaxCount());
        return organism;
    }

    protected abstract Organism createSpecific();
}
