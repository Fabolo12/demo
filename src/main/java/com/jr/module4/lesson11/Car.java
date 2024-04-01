package com.jr.module4.lesson11;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Car {
    @Id
    @GeneratedValue
    private UUID id;

    private String model;

    private int year;
}
