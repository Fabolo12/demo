package com.jr.module4.lesson14;

import com.jr.module4.HibernateFactoryUtil;
import com.jr.module4.lesson14.join.JoinChildFirst;
import com.jr.module4.lesson14.join.JoinChildSecond;
import com.jr.module4.lesson14.join.MyJoin;
import com.jr.module4.lesson14.perclass.MyTablePerClass;
import com.jr.module4.lesson14.perclass.TablePerClassChildFirst;
import com.jr.module4.lesson14.perclass.TablePerClassChildSecond;
import com.jr.module4.lesson14.sinle.MySingleTable;
import com.jr.module4.lesson14.sinle.SingleTableChildFirst;
import com.jr.module4.lesson14.sinle.SingleTableChildSecond;
import com.jr.module4.lesson14.superclass.MappedSuperclassChildFirst;
import com.jr.module4.lesson14.superclass.MappedSuperclassChildSecond;
import com.jr.module4.lesson14.superclass.MyMappedSuperclass;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.function.Supplier;

public class Main {

    private static final String PARENT_NAME_FIRST = "Parent 1";

    private static final String PARENT_NAME_SECOND = "Parent 2";

    private static final String CHILD_NAME_FIRST = "Child 1";

    private static final String CHILD_NAME_SECOND = "Child 2";

    public static void main(String[] args) {
//        superclass();
//        singleTable();
//        join();
        tablePerClass();
    }

    private static void tablePerClass() {
        final Supplier<List<?>> body = () -> {
            final TablePerClassChildFirst first = new TablePerClassChildFirst();
            first.setName(PARENT_NAME_FIRST);
            first.setChildNameFirst(CHILD_NAME_FIRST);

            final TablePerClassChildSecond second = new TablePerClassChildSecond();
            second.setName(PARENT_NAME_SECOND);
            second.setChildNameSecond(CHILD_NAME_SECOND);

            return List.of(first, second);
        };


        execute(body, MyTablePerClass.class, TablePerClassChildFirst.class, TablePerClassChildSecond.class);
    }

    private static void join() {
        final Supplier<List<?>> body = () -> {
            final JoinChildFirst first = new JoinChildFirst();
            first.setName(PARENT_NAME_FIRST);
            first.setChildNameFirst(CHILD_NAME_FIRST);

            final JoinChildSecond second = new JoinChildSecond();
            second.setName(PARENT_NAME_SECOND);
            second.setChildNameSecond(CHILD_NAME_SECOND);

            return List.of(first, second);
        };


        execute(body, MyJoin.class, JoinChildFirst.class, JoinChildSecond.class);
    }

    private static void singleTable() {
        final Supplier<List<?>> body = () -> {
            final SingleTableChildFirst first = new SingleTableChildFirst();
            first.setName(PARENT_NAME_FIRST);
            first.setChildNameFirst(CHILD_NAME_FIRST);

            final SingleTableChildSecond second = new SingleTableChildSecond();
            second.setName(PARENT_NAME_SECOND);
            second.setChildNameSecond(CHILD_NAME_SECOND);

            return List.of(first, second);
        };


        execute(body, MySingleTable.class, SingleTableChildFirst.class, SingleTableChildSecond.class);
    }

    private static void superclass() {
        final Supplier<List<?>> body = () -> {
            final MappedSuperclassChildFirst first = new MappedSuperclassChildFirst();
            first.setName(PARENT_NAME_FIRST);
            first.setChildNameFirst(CHILD_NAME_FIRST);

            final MappedSuperclassChildSecond second = new MappedSuperclassChildSecond();
            second.setName(PARENT_NAME_SECOND);
            second.setChildNameSecond(CHILD_NAME_SECOND);

            return List.of(first, second);
        };


        execute(body, MyMappedSuperclass.class, MappedSuperclassChildFirst.class, MappedSuperclassChildSecond.class);
    }

    private static void execute(
            final Supplier<List<?>> body,
            final Class<?> parent,
            final Class<?> childFirst,
            final Class<?> childSecond
    ) {
        try (final EntityManager entityManager = HibernateFactoryUtil.getEntityManager()) {
            System.out.println();
            System.out.println();
            System.out.println("Insert classes");
            entityManager.getTransaction().begin();
            body.get().forEach(entityManager::persist);
            entityManager.getTransaction().commit();

            System.out.println("~".repeat(10));
            System.out.println("Get Parent class:");
            print(entityManager, parent);
            System.out.println("~".repeat(10));
            System.out.println("Get child classes");
            print(entityManager, childFirst);
            print(entityManager, childSecond);
        }
    }

    private static void print(final EntityManager entityManager, final Class<?> clazz) {
        try {
            entityManager.createQuery(String.format("from %s a", clazz.getSimpleName()), clazz)
                    .getResultList().forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.out.printf("Cannot get %s class%n", clazz.getSimpleName());
        }
    }
}
