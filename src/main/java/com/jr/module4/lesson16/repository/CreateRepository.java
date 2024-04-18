package com.jr.module4.lesson16.repository;

import com.jr.module4.HibernateFactoryUtil;
import com.jr.module4.lesson9.model.MyClient;
import lombok.Getter;

import java.util.UUID;

public class CreateRepository extends AbstractRepository<MyClient, UUID> {
    @Getter
    private static final CreateRepository instance = new CreateRepository();

    private CreateRepository() {
        super(HibernateFactoryUtil.getEntityManager(), MyClient.class);
    }

    public MyClient create() {
        final MyClient myClient = new MyClient();
        myClient.setId(UUID.randomUUID());
        save(myClient);
        return myClient;
    }
}
