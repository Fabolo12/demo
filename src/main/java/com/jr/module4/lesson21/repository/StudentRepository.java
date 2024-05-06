package com.jr.module4.lesson21.repository;

import com.jr.module4.HibernateFactoryUtil;
import com.jr.module4.lesson21.model.Student;

public class StudentRepository extends AbstractRepository<Student> {
    private static StudentRepository repository;

    private StudentRepository() {
        super(HibernateFactoryUtil.getEntityManager(), Student.class);
    }

    public static StudentRepository getInstance() {
        if (repository == null) {
            repository = new StudentRepository();
        }
        return repository;
    }
}
