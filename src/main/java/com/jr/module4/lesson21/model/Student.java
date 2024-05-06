package com.jr.module4.lesson21.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Student {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String email;

    private String city;

    private String country;

    @ToString.Exclude
    @ManyToOne
    private StudentGroup group;

    @OneToOne
    private Profile profile;
}
