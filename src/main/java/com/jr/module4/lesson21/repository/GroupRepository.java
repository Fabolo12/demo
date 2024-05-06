package com.jr.module4.lesson21.repository;

import com.jr.module4.HibernateFactoryUtil;
import com.jr.module4.lesson21.model.StudentGroup;

public class GroupRepository extends AbstractRepository<StudentGroup> {
    private static GroupRepository repository;

    private GroupRepository() {
        super(HibernateFactoryUtil.getEntityManager(), StudentGroup.class);
    }

    public static GroupRepository getInstance() {
        if (repository == null) {
            repository = new GroupRepository();
        }
        return repository;
    }
}
