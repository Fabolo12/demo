package com.jr.module3.lesson15.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserData implements Serializable {

    public static final String SESSION_ATTRIBUTE = "userData";

    private final String username;
    private final LocalDate date;
    private int score;
}
