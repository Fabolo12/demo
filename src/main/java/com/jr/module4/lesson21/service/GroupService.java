package com.jr.module4.lesson21.service;

import com.jr.module4.lesson21.model.Course;
import com.jr.module4.lesson21.model.StudentGroup;
import com.jr.module4.lesson21.repository.GroupRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GroupService {
    private static GroupService instance;

    private final GroupRepository repository;

    private final StudentService studentService;
    private final CourseService courseService;


    private GroupService(
            final GroupRepository repository,
            final StudentService studentService,
            final CourseService courseService
    ) {
        this.repository = repository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public static GroupService getInstance(
            final GroupRepository repository,
            final StudentService studentService,
            final CourseService courseService
    ) {
        if (instance == null) {
            instance = new GroupService(repository, studentService, courseService);
        }
        return instance;
    }


    public List<StudentGroup> createRandomGroup(final int groupCount, final int studentCount) {
        List<StudentGroup> rc = new ArrayList<>();
        for (int i = 0; i < groupCount; i++) {
            final StudentGroup studentGroup = new StudentGroup();
            studentGroup.setName("Group " + i);
            studentGroup.setStarted(LocalDate.now());
            studentService.createRandomStudent(studentCount).forEach(studentGroup::addStudent);
            repository.save(studentGroup);
            studentGroup.addCourse(courseService.createRandomCourse());
            repository.save(studentGroup);
            rc.add(studentGroup);
        }
        return rc;
    }
}
