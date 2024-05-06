package com.jr.module4.lesson21.service;

import com.jr.module4.lesson21.model.Student;
import com.jr.module4.lesson21.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class StudentService {
    private static StudentService service;

    private final StudentRepository repository;

    private final ProfileService profileService;

    private final Random random = new Random();

    private StudentService(
            final StudentRepository repository,
            final ProfileService profileService
    ) {
        this.repository = repository;
        this.profileService = profileService;
    }

    public static StudentService getInstance(
            final StudentRepository repository,
            final ProfileService profileService
    ) {
        if (service == null) {
            service = new StudentService(repository, profileService);
        }
        return service;
    }

    public List<Student> createRandomStudent(final int count) {
        List<Student> rc = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            final Student student = createStudent();
            repository.save(student);
            rc.add(student);
        }
        return rc;
    }

    public Student getStudent(final UUID id) {
        return repository.findById(id).orElseThrow();
    }

    private Student createStudent() {
        final Student student = new Student();
        student.setName("Name-" + random.nextInt(1000));
        student.setEmail("Email");
        student.setCity("City");
        student.setCountry("Country");
        student.setProfile(profileService.createRandomProfile());
        return student;
    }
}
