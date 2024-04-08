package com.jr.module4.lesson10;

import com.jr.module4.HibernateFactoryUtil;
import com.jr.module4.lesson9.model.MyClient;
import org.flywaydb.core.Flyway;
import org.hibernate.Session;

import java.util.Random;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        MyClient client = null;
        for (int i = 0; i < 10; i++) {
            client = createClient();
        }

        try {
            final Flyway flyway = Flyway.configure()
                    .dataSource("jdbc:postgresql://localhost:5432/test", "postgres", "root")
                    .baselineOnMigrate(true)
                    .cleanDisabled(false)
                    .locations("db/migration")
                    .load();

            flyway.clean();
            flyway.migrate();
        } catch (Exception e) {
            e.printStackTrace();
        }




//        createQuery(client);
//        createNamedQuery();
//        createNativeQuery(client);
    }

    private static void createNativeQuery(final MyClient client) {
        try (final Session session = HibernateFactoryUtil.openSession()) {
            System.out.println("Native query");
            final MyClient myClient = session.createNativeQuery(
                    "SELECT * FROM client where id = :id", MyClient.class
                    ).setParameter("id", client.getId())
                    .getSingleResultOrNull();
            System.out.println(myClient);
        }
    }

    private static void createNamedQuery() {
        try (final Session session = HibernateFactoryUtil.openSession()) {
            System.out.println("Named query");
            session.createNamedQuery("getAll",  MyClient.class)
                    .getResultStream()
                    .forEach(Main::print);
        }
    }

    private static void createQuery(final MyClient client) {
        try (final Session session = HibernateFactoryUtil.openSession()) {
            session.createQuery("from MyClient", MyClient.class)
                    .list()
                    .forEach(Main::print);

            System.out.println("Single result");
            final MyClient singleResult = session.createQuery("from MyClient c where c.id = :id", MyClient.class)
                    .setParameter("id", client.getId())
                    .getSingleResult();
            System.out.println(singleResult);

            System.out.println("Like result");
            session.createQuery("from MyClient c where c.name like :name", MyClient.class)
                    .setParameter("name", String.format("%%%s%%", client.getName().substring(2)))
                    .getResultStream()
                    .forEach(Main::print);

            System.out.println("Constructor in HQL / DTO");
            session.createQuery("select new com.jr.module4.lesson10.IdWithAge(c.id, c.age) from MyClient c",
                            IdWithAge.class)
                    .getResultStream()
                    .forEach(System.out::println);

            /*System.out.println("ResultTransformer in HQL / DTO");
            final Query query = session.createQuery("select c.id, c.age from MyClient c");
            query.setResultListTransformer(Transformers.aliasToBean(IdWithAge.class));
            final List<IdWithAge> list = query.list();
            list.forEach(System.out::println);*/
        }
    }

    private static void print(final MyClient client) {
        System.out.printf("MyClient id: %s , age: %d%n", client.getId(), client.getAge());
    }

    private static MyClient createClient() {
        try (final Session session = HibernateFactoryUtil.openSession()) {
            final MyClient user = new MyClient(UUID.randomUUID(), "");
            user.setName("Test");
            user.setAge(new Random().nextInt(100));
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
            return user;
        }
    }
}


record IdWithAge(UUID id, int age) {}