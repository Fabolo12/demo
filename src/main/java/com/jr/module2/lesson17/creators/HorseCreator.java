package com.jr.module2.lesson17.creators;

import com.jr.module2.lesson17.models.Animal;
import com.jr.module2.lesson17.models.Horse;
import com.jr.module2.lesson17.models.Organism;

public class HorseCreator extends OrganismCreator {

    @Override
    protected Organism createSpecific() {
        final Horse horse = new Horse();
        System.out.println(horse.getClass().getSimpleName() + " created");
        return horse;
    }
}
