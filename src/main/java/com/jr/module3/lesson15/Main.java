package com.jr.module3.lesson15;

import com.jr.module3.lesson15.service.GameLoadSystem;

public class Main {
    public static void main(String[] args) {
        final GameLoadSystem loadSystem = new GameLoadSystem("game1.json");
        loadSystem.load();
    }
}
