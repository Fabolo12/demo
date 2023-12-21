package com.jr.module2.lesson17.service;

import com.jr.module2.lesson17.config.ConfigLoader;
import com.jr.module2.lesson17.models.Grass;
import com.jr.module2.lesson17.models.Map;

import java.util.List;

public class GrassCycle implements Runnable {
    @Override
    public void run() {
        final Map map = Map.getInstance();
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                final Map.Cell cell = map.getCell(i, j);
                if (isHasGrass(cell)) {
                    increaseGrass(map, cell);
                }
            }
        }
    }

    private void increaseGrass(final Map map, final Map.Cell cell) {
        final List<Grass> grasses = cell.getGrasses();
        final String grassConfigKey = grasses.get(0).getConfigKey();
        final int height = cell.getHeight();
        final int width = cell.getWidth();
        final int increaseCount = ConfigLoader.getIntegerProperty(grassConfigKey + "increase-count");
        int newGrassCount = 0;
        for (Grass grass : grasses) {
            for (int i = 0; i < increaseCount; i++) {
                newGrassCount++;
            }
        }

        for (int i = 0; i < newGrassCount; i++) {
            map.addGrass(height, width);
        }
    }

    private boolean isHasGrass(final Map.Cell cell) {
        return !cell.getGrasses().isEmpty();
    }
}
