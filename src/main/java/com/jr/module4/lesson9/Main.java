package com.jr.module4.lesson9;


import com.jr.module4.HibernateFactoryUtil;
import com.jr.module4.lesson9.model.MyClient;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
//        jpaHibernate();
        nativeHibernate();

        System.out.println("Test");
    }

    private static void jpaHibernate() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        final MyClient user = new MyClient(UUID.randomUUID(), "");
        user.setName("Test");
        user.setAge(20);
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();

        final EntityManager entityManager1 = HibernateFactoryUtil.getEntityManager();
        final MyClient user1 = entityManager1.find(MyClient.class, user.getId());
        System.out.println("jpaHibernate: " + user1);
    }

    private static void nativeHibernate() {
        final Session session = HibernateFactoryUtil.openSession();
        final MyClient user = new MyClient(UUID.randomUUID(), "");
        user.setName("Test");
        user.setAge(20);
        session.beginTransaction();
//        session.save(user); @Deprecated
        session.persist(user);
        session.getTransaction().commit();
        session.close();

        final Session session1 = HibernateFactoryUtil.openSession();
        final MyClient user1 = session1.get(MyClient.class, user.getId());
        session1.persist(user);
        System.out.println("nativeHibernate: " + user1);
    }
}
