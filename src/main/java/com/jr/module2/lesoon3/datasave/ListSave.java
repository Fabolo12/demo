package com.jr.module2.lesoon3.datasave;

import java.util.ArrayList;
import java.util.List;

class ListSave implements Save {
    private final List<String> list = new ArrayList<>();

    @Override
    public boolean save(final String line) {
        if (canNotSave(line)) {
            return false;
        }
        return list.add(line);
    }

    private boolean canNotSave(final String line) {
        return line == null || line.isEmpty();
    }
}
