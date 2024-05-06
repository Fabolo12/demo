package com.jr.module4.lesson21.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Profile {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String description;

    @ToString.Exclude
    @OneToOne(mappedBy = "profile")
    private Student student;
}
