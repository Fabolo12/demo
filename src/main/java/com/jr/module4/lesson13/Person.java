package com.jr.module4.lesson13;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Person {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Passport passport;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "person")
    private Set<Address> addresses;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "people")
    private Set<Work> works;

    public void setPassport(final Passport passport) {
        passport.setPerson(this);
        this.passport = passport;
    }

    public void setAddresses(final Set<Address> addresses) {
        addresses.forEach(address -> address.setPerson(this));
        this.addresses = addresses;
    }

    public void setWorks(final Set<Work> works) {
        works.forEach(work -> work.getPeople().add(this));
        this.works = works;
    }
}
