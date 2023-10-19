package com.jr.module2.lesoon3.menu.actions;

import java.time.LocalDateTime;

public class ShowTime implements Action {
    @Override
    public void exec() {
        System.out.println(LocalDateTime.now());
    }
}
