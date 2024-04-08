package com.jr.module4.lesson13;

import jakarta.persistence.CascadeType;
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
public class Work {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @ManyToMany
    @ToString.Exclude
    private Set<Person> people = new HashSet<>();

}
