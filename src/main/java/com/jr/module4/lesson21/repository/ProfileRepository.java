package com.jr.module4.lesson21.repository;

import com.jr.module4.HibernateFactoryUtil;
import com.jr.module4.lesson21.model.Profile;
import com.jr.module4.lesson21.model.Student;

public class ProfileRepository extends AbstractRepository<Profile> {
    private static ProfileRepository repository;

    private ProfileRepository() {
        super(HibernateFactoryUtil.getEntityManager(), Profile.class);
    }

    public static ProfileRepository getInstance() {
        if (repository == null) {
            repository = new ProfileRepository();
        }
        return repository;
    }
}
