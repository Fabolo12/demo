package com.jr.module3.lesson15.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {
    private boolean lose;
    private String text;
    private int nextQuestion;
}
