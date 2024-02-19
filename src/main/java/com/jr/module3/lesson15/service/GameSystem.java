package com.jr.module3.lesson15.service;

import com.jr.module3.lesson15.model.Question;

import java.util.List;

public class GameSystem {

    private static GameSystem instance;

    private final List<Question> questions;

    private GameSystem(final List<Question> questions) {
        this.questions = questions;
    }

    public static GameSystem getInstance() {
        if (instance == null) {
            final GameLoadSystem loadSystem = new GameLoadSystem("game1.json");  // TODO 19/02/24
            instance = new GameSystem(loadSystem.load());
        }
        return instance;
    }

    public Question getStartQuestion() {
        return questions.get(0);
    }
}
