package com.jr.module4.lesson9.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "client")
@NamedQueries({
    @NamedQuery(
            name = "getAll",
            query = "select m from MyClient m"
    )
})
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
