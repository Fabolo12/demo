package com.jr.module4.lesson9.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "client")
public class MyClient {
    @Id
    private UUID id;

    private String name;

    private int age;

    public MyClient(final UUID id, final String name) {
        this.id = id;
        this.name = name;
    }
}
