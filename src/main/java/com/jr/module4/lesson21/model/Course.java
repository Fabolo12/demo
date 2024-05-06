package com.jr.module4.lesson21.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Course {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String description;
    private int monthDuration;
    private double price;

    @ToString.Exclude
    @ManyToMany(mappedBy = "courses")
    private Set<StudentGroup> studentGroups = new HashSet<>();
}
