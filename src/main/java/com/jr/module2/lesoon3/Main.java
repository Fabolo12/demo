package com.jr.module2.lesoon3;

import com.jr.module2.lesoon3.datasave.Save;
import com.jr.module2.lesoon3.datasave.SaveFactory;
import com.jr.module2.lesoon3.datasave.SaveType;

public class Main {
    public static void main(String[] args) {
        final Save save = SaveFactory.getSave(SaveType.LIST);
        System.out.println("Save line " + save.save("123"));
    }
}
