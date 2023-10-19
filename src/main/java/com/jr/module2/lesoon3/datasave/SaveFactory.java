package com.jr.module2.lesoon3.datasave;

public class SaveFactory {
    public static Save getSave(final SaveType type) {
        return switch (type) {
            case ARRAY -> new ArrraySave();
            case LIST -> new ListSave();
            default -> throw new IllegalArgumentException(type.name());
        };
    }
}
