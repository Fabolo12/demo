package com.jr.module4.lesson14.perclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class TablePerClassChildSecond extends MyTablePerClass {
    private String childNameSecond;
}
