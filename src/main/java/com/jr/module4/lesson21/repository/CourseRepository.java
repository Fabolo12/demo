package com.jr.module4.lesson21.repository;

import com.jr.module4.HibernateFactoryUtil;
import com.jr.module4.lesson21.model.Course;
import com.jr.module4.lesson21.model.Student;

public class CourseRepository extends AbstractRepository<Course> {
    private static CourseRepository repository;

    private CourseRepository() {
        super(HibernateFactoryUtil.getEntityManager(), Course.class);
    }

    public static CourseRepository getInstance() {
        if (repository == null) {
            repository = new CourseRepository();
        }
        return repository;
    }
}
