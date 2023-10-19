package com.jr.module2.lesoon3.datasave;

class ArrraySave implements Save {
    private final String[] lines = new String[10];

    @Override
    public boolean save(final String line) {
        boolean isSave = false;
        if (canNotSave(line)) {
            return isSave;
        }
        for (int i = 0; i < lines.length; i++) {
            if (lines[i] == null) {
                lines[i] = line;
                isSave = true;
            }
        }
        return isSave;
    }

    private boolean canNotSave(final String line) {
        return line == null || line.isEmpty();
    }
}
