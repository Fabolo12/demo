package com.jr.module4.lesson14.superclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class MappedSuperclassChildFirst extends MyMappedSuperclass {
    private String childNameFirst;
}
