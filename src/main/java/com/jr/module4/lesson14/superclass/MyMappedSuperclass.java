package com.jr.module4.lesson14.superclass;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class MyMappedSuperclass {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
}
