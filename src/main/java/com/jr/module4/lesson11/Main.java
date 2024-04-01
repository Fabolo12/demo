package com.jr.module4.lesson11;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        final Session session = HibernateFactoryUtil.openSession();
        final Transaction transaction = session.beginTransaction();
        final Car car = new Car();
        car.setModel("test");
        car.setYear(2000);
        session.persist(car);
        final Car car2 = new Car();
        car2.setModel("test");
        car2.setYear(2000);
        session.persist(car2);
        final Car car3 = new Car();
        car3.setModel("test");
        car3.setYear(2000);
        session.persist(car3);
        transaction.commit();
        session.close();

        final Session session2 = HibernateFactoryUtil.openSession();
        final Car getCar = session2.get(Car.class, car.getId());
        final Car getCarError = session2.get(Car.class, UUID.randomUUID());
        final Car referenceCar = session2.getReference(Car.class, car2.getId());
        final Car findCar = session2.find(Car.class, car3.getId());
        final Car findCarError = session2.find(Car.class, UUID.randomUUID());
        System.out.println("Get data from proxy object: " + referenceCar.getModel());
        session2.close();
        System.out.println(getCar.getClass());
        System.out.println(getCar);
        System.out.println(getCarError);

        System.out.println();
        System.out.println(referenceCar.getClass());
        System.out.println(referenceCar.getId());
        System.out.println(referenceCar);

        System.out.println();
        System.out.println(findCar.getClass());
        System.out.println(findCar.getId());
        System.out.println(findCar);
        System.out.println(findCarError);
    }

    private void example3() {
        final Session session = HibernateFactoryUtil.openSession();
        final Transaction transaction = session.beginTransaction();
        final Car car = new Car();
        car.setModel("test");
        car.setYear(2000);
        session.persist(car);
        transaction.commit();
        session.close();

        final Session session2 = HibernateFactoryUtil.openSession();
        final Transaction transaction2 = session2.beginTransaction();
        car.setYear(2001);
        final Car persistedCar = session2.merge(car);
        persistedCar.setYear(2002);
        session2.persist(persistedCar);
        transaction2.commit();
        session2.close();
    }

    private void example2() {
        final Session session = HibernateFactoryUtil.openSession();
        final Transaction transaction = session.beginTransaction();
        final Car car = new Car();
        car.setModel("test");
        car.setYear(2000);
        System.out.println("Before save: " + car);
        System.out.println("Key: " + session.save(car));
        System.out.println("After save: " + car);
        transaction.commit();
        session.close();
    }

    private void example1() {
        final Session session = HibernateFactoryUtil.openSession();
        final Transaction transaction = session.beginTransaction();
        final Car car = new Car();
        car.setModel("test");
        car.setYear(2000);
        session.persist(car);
//        session.flush();
        transaction.commit();
        session.close();

        final Session session2 = HibernateFactoryUtil.openSession();
        final Car car1 = session2.get(Car.class, car.getId());
        System.out.println(car1);

        final Transaction transaction2 = session2.beginTransaction();
        car1.setYear(2001);
        session2.persist(car1);
        transaction2.commit();
        session2.close();
    }
}
