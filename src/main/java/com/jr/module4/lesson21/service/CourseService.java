package com.jr.module4.lesson21.service;

import com.jr.module4.lesson21.model.Course;
import com.jr.module4.lesson21.repository.CourseRepository;

import java.util.Random;

public class CourseService {
    private static CourseService instance;

    private final CourseRepository repository;

    private final Random random = new Random();

    private CourseService(
            final CourseRepository repository
    ) {
        this.repository = repository;
    }

    public static CourseService getInstance(
            final CourseRepository repository
    ) {
        if (instance == null) {
            instance = new CourseService(repository);
        }
        return instance;
    }


    public Course createRandomCourse() {
        final Course course = new Course();
        course.setName("Course " + random.nextInt(1000));
        course.setDescription("Description");
        course.setMonthDuration(3);
        course.setPrice(1000);
        repository.save(course);
        return course;
    }
}
