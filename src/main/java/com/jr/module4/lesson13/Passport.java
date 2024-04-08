package com.jr.module4.lesson13;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Setter
@Getter
@ToString(exclude = "person")
public class Passport {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @OneToOne(mappedBy = "passport")
    private Person person;
}
