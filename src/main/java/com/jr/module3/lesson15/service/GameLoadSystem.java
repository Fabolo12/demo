package com.jr.module3.lesson15.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jr.module3.lesson15.model.Question;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameLoadSystem {
    private final String gamePath;

    public GameLoadSystem(final String gameName) {
        this.gamePath = "module3/lesson15/" + gameName;
    }

    public List<Question> load() {
        return map(loadJsonGame());
    }

    private List<Question> map(final String jsonGame) {
        Type listType = new TypeToken<ArrayList<Question>>() {
        }.getType();
        return new Gson().fromJson(jsonGame, listType);
    }

    @SneakyThrows
    private String loadJsonGame() {
        final ClassLoader classLoader = getClass().getClassLoader();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(classLoader.getResourceAsStream(gamePath)), StandardCharsets.UTF_8
                )
        )) {
            final StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            return builder.toString();
        }
    }
}
