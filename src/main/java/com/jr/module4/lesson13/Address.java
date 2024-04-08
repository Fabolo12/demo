package com.jr.module4.lesson13;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Setter
@Getter
@ToString
public class Address {
    @Id
    @GeneratedValue
    private UUID id;

    private String city;

    @ManyToOne
    @ToString.Exclude
    private Person person;
}
