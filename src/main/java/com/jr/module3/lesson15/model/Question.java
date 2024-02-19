package com.jr.module3.lesson15.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Question {
    private int id;
    private String text;
    private List<Answer> answers;
}