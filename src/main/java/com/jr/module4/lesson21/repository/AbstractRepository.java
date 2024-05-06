package com.jr.module4.lesson21.repository;

import jakarta.persistence.EntityManager;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public abstract class AbstractRepository<T> {
    protected final EntityManager entityManager;

    protected final Class<T> clazz;

    protected AbstractRepository(EntityManager entityManager, final Class<T> clazz) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }

    public Stream<T> getAll() {
        return entityManager.createQuery("from %s".formatted(clazz.getSimpleName()), clazz).getResultStream();
    }

    public Optional<T> findById(UUID id) {
        return Optional.ofNullable(entityManager.find(clazz, id));
    }

    public void save(T value) {
        entityManager.getTransaction().begin();
        entityManager.persist(value);
        entityManager.getTransaction().commit();
    }

    public void update(T value) {
        entityManager.getTransaction().begin();
        entityManager.merge(value);
        entityManager.getTransaction().commit();
    }

    public void delete(T value) {
        entityManager.getTransaction().begin();
        entityManager.remove(value);
        entityManager.getTransaction().commit();
    }

    public void deleteById(UUID id) {
        final T value = entityManager.find(clazz, id);
        entityManager.getTransaction().begin();
        entityManager.remove(value);
        entityManager.getTransaction().commit();
    }
}
