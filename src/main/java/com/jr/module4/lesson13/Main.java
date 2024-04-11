package com.jr.module4.lesson13;

import com.jr.module4.HibernateFactoryUtil;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        final ElementCollectionExample example = new ElementCollectionExample();
        example.setName("example 1");
        entityManager.persist(example);
        entityManager.getTransaction().commit();
        entityManager.close();

        final EntityManager entityManager1 = HibernateFactoryUtil.getEntityManager();
        System.out.println("Find 1");
        entityManager1.find(ElementCollectionExample.class, example.getId());
        entityManager1.find(ElementCollectionExample.class, example.getId());
        entityManager1.clear();
        System.out.println("Find 2");
        entityManager1.find(ElementCollectionExample.class, example.getId());
        final EntityManager entityManager2 = HibernateFactoryUtil.getEntityManager();
        System.out.println("Find 3");
        entityManager2.find(ElementCollectionExample.class, example.getId());
    }

    private static void manyToManyExample() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();

        final Person person1 = new Person();
        person1.setName("Persona 1");

        final Person person2 = new Person();
        person2.setName("Persona 2");

        final Work work1 = new Work();
        work1.setName("Work 1");
        final Work work2 = new Work();
        work2.setName("Work 2");

        final Set<Work> works = Set.of(work1, work2);

        person1.setWorks(works);
        person2.setWorks(works);

        entityManager.persist(person1);
        entityManager.persist(person2);

        entityManager.getTransaction().commit();
        entityManager.close();

        final EntityManager entityManager1 = HibernateFactoryUtil.getEntityManager();
        final Person rcPerson = entityManager1.find(Person.class, person1.getId());
//        entityManager1.close();
        System.out.println(rcPerson.getId());
        System.out.println("~~~~");
        System.out.println("Works size: " + rcPerson.getWorks().size());
        System.out.println("Works size: " + rcPerson.getWorks().size());
        System.out.println("Addresses size: " + rcPerson.getAddresses().size());
    }

    private static void oneToManyExample() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();

        final Person person = new Person();
        person.setName("Persona 1");

        final Address address1 = new Address();
        address1.setCity("UK");
        address1.setPerson(person);
        final Address address2 = new Address();
        address2.setCity("UR");
        address2.setPerson(person);

        person.setAddresses(Set.of(address1, address2));

        entityManager.persist(person);

        entityManager.getTransaction().commit();
        entityManager.close();

        final EntityManager entityManager1 = HibernateFactoryUtil.getEntityManager();
        final Person rcPerson = entityManager1.find(Person.class, person.getId());
        System.out.println(rcPerson);
    }

    private static void oneToOneExample() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();

        final Passport passport = new Passport();
        passport.setName("Passport 1");

        final Person person = new Person();
        person.setName("Persona 1");
        person.setPassport(passport);
        entityManager.persist(person);

        System.out.println(passport.getPerson().getId());

        entityManager.getTransaction().commit();
        entityManager.close();

        final EntityManager entityManager1 = HibernateFactoryUtil.getEntityManager();
        final Person rcPerson = entityManager1.find(Person.class, person.getId());
        System.out.println(rcPerson.getPassport().getName());

        final Passport rcPassport = entityManager1.find(Passport.class, passport.getId());
        System.out.println(rcPassport.getPerson().getName());

        System.out.println(rcPerson);
    }

    private static void elementCollectionExample() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        final ElementCollectionExample example = new ElementCollectionExample();
        example.setName("example 1");
        example.setMessages(List.of("value 1", "value 2"));
//        example.setMessages2(List.of(new Message("value 1")));
        example.setMessages3(Map.of("key 1", "value 1"));
        entityManager.persist(example);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
