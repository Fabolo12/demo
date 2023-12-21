package com.jr.module2.lesson17;

import com.jr.module2.lesson17.creators.HorseCreator;
import com.jr.module2.lesson17.creators.OrganismCreator;
import com.jr.module2.lesson17.models.AnimalType;
import com.jr.module2.lesson17.models.Horse;

public class CreatorExample {
    public static void main(String[] args) {
        OrganismCreator creator = buildCreator(AnimalType.HORSE);
        final Horse horse = (Horse) creator.create();
    }

    private static OrganismCreator buildCreator(final AnimalType type) {
        return switch (type) {
            case HORSE -> new HorseCreator();
            case WOLF -> new HorseCreator();
        };
    }
}
