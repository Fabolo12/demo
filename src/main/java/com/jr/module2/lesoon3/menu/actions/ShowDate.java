package com.jr.module2.lesoon3.menu.actions;

import java.time.LocalDate;

class ShowDate implements Action {
    @Override
    public void exec() {
        System.out.println(LocalDate.now());
    }
}
