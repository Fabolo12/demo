package com.jr.module4.lesson16.repository;

import com.jr.module4.HibernateFactoryUtil;
import com.jr.module4.lesson9.model.MyClient;
import lombok.Getter;

import java.util.Optional;
import java.util.UUID;

public class ClientRepository extends AbstractRepository<MyClient, UUID> {

    @Getter
    private static final ClientRepository instance = new ClientRepository();

    private ClientRepository() {
        super(HibernateFactoryUtil.getEntityManager(), MyClient.class);
    }

    public Optional<MyClient> findByName(String name) {
        return Optional.ofNullable(
                entityManager.createQuery("from MyClient where name = :name", MyClient.class)
                        .setParameter("name", name)
                        .getSingleResult()
        );
    }
}
