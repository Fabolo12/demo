package com.jr.module4.lesson13;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Getter
@Setter
public class ElementCollectionExample {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @ElementCollection
    private List<String> messages;

    /*@ElementCollection
    private List<Message> messages2;*/

    @ElementCollection
    private Map<String, String> messages3;
}


record Message(String value) {
}
