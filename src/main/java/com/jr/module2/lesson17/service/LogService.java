package com.jr.module2.lesson17.service;

import com.jr.module2.lesson17.models.Map;

public class LogService {
    public void logInfo() {
        final Map map = Map.getInstance();
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                final Map.Cell cell = map.getCell(i, j);
                System.out.println("Cell " + i + " " + j);
                System.out.println("Animals size: " + cell.getAnimals().size());
                System.out.println("Grasses size: " + cell.getGrasses().size());
                System.out.println("Animal load: " + cell.getAnimalLoad());
                System.out.println("Grass load: " + cell.getGrassLoad());
                System.out.println("~~~~~~~~~~~");
            }
        }
    }
}
