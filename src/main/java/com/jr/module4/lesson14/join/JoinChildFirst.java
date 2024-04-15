package com.jr.module4.lesson14.join;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class JoinChildFirst extends MyJoin {
    private String childNameFirst;
}
