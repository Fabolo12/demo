package com.jr.module4.lesson16.repository;

import com.jr.module4.HibernateFactoryUtil;
import com.jr.module4.lesson11.Car;
import lombok.Getter;

import java.util.UUID;

public class CarRepository extends AbstractRepository<Car, UUID> {

    @Getter
    private static final CarRepository instance = new CarRepository();

    public CarRepository() {
        super(HibernateFactoryUtil.getEntityManager(), Car.class);
    }
}
