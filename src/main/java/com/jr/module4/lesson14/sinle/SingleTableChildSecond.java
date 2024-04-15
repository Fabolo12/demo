package com.jr.module4.lesson14.sinle;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class SingleTableChildSecond extends MySingleTable {
    private String childNameSecond;
}
