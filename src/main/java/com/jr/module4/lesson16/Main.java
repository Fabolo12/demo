package com.jr.module4.lesson16;

import com.jr.module4.HibernateFactoryUtil;
import com.jr.module4.lesson16.repository.CarRepository;
import com.jr.module4.lesson16.repository.ClientRepository;
import com.jr.module4.lesson9.model.MyClient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        init();
//        System.out.println("Without Criteria");
//        withoutCriteria("C", 20);
//        System.out.println();
//        System.out.println("With Criteria");
//        withCriteria("C", 20);
//        System.out.println("Rollback");
//        rollback();

        useDao();
    }


    private static void useDao() {
        final ClientRepository repository = ClientRepository.getInstance();
        repository.getAll().forEach(System.out::println);

        repository.findById(UUID.randomUUID())
                .map(MyClient::getName)
                .ifPresent(System.out::println);

        CarRepository.getInstance().getAll()
                .forEach(System.out::println);
    }

    private static void rollback() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        try {
            final MyClient myClient = new MyClient();
            myClient.setId(UUID.randomUUID());
            myClient.setName("Error client");
            myClient.setAge(-1);
            entityManager.persist(myClient);
            throw new IllegalStateException();
        } catch (IllegalStateException e) {
            entityManager.getTransaction().rollback();
            entityManager.getTransaction().begin();
            System.out.println("Rollback");
            final MyClient myClient = new MyClient();
            myClient.setId(UUID.randomUUID());
            myClient.setName("Default client");
            myClient.setAge(0);
            entityManager.persist(myClient);
        }
        entityManager.getTransaction().commit();
        entityManager.close();

        final EntityManager entityManager2 = HibernateFactoryUtil.getEntityManager();
        entityManager2.getTransaction().begin();
        final MyClient myClient = new MyClient();
        myClient.setId(UUID.randomUUID());
        myClient.setName("Error client 2");
        myClient.setAge(-1);
        entityManager2.persist(myClient);
        throw new IllegalStateException();
    }

    private static void withCriteria(final String name, final Integer age) {
        try (final EntityManager entityManager = HibernateFactoryUtil.getEntityManager()) {
            final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            final CriteriaQuery<MyClient> query = builder.createQuery(MyClient.class);
            final Root<MyClient> root = query.from(MyClient.class);
            query.select(root);

            final Predicate namePredicate = name != null && !name.isEmpty()
                    ? builder.like(root.get("name"), "%" + name + "%")
                    : null;

            final Predicate agePredicate = age != null && age > 10
                    ? builder.greaterThan(root.get("age"), age)
                    : null;

            query.where(builder.and(namePredicate, agePredicate));

            entityManager.createQuery(query)
                    .getResultList()
                    .forEach(System.out::println);

        }
    }

    private static void withoutCriteria(final String name, final Integer age) {
        try (final EntityManager entityManager = HibernateFactoryUtil.getEntityManager()) {
            String query = "from MyClient";
            List<String> conditions = new ArrayList<>();

            if (name != null && !name.isEmpty()) {
                conditions.add("name like '%" + name + "%'");
            }

            if (age != null && age > 10) {
                conditions.add("age > " + age);
            }

            if (!conditions.isEmpty()) {
                query += " where " + String.join(" and ", conditions);
            }

            entityManager.createQuery(query, MyClient.class)
                    .getResultList()
                    .forEach(System.out::println);
        }
    }

    private static void init() {
        try (final EntityManager entityManager = HibernateFactoryUtil.getEntityManager()) {
            final Random random = new Random();
            entityManager.getTransaction().begin();
            for (int i = 0; i < 10; i++) {
                final MyClient myClient = new MyClient();
                myClient.setId(UUID.randomUUID());
                myClient.setName("Client" + i);
                myClient.setAge(random.nextInt(100));
                entityManager.persist(myClient);
            }
            entityManager.getTransaction().commit();
        }

    }
}
