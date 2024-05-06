package com.jr.module4.lesson21;

import com.jr.module4.lesson21.repository.CourseRepository;
import com.jr.module4.lesson21.repository.GroupRepository;
import com.jr.module4.lesson21.repository.ProfileRepository;
import com.jr.module4.lesson21.repository.StudentRepository;
import com.jr.module4.lesson21.service.CourseService;
import com.jr.module4.lesson21.service.GroupService;
import com.jr.module4.lesson21.service.ProfileService;
import com.jr.module4.lesson21.service.StudentService;

public class Main {
    public static void main(String[] args) {
        final ProfileService profileService = ProfileService.getInstance(ProfileRepository.getInstance());

        final StudentService studentService = StudentService.getInstance(StudentRepository.getInstance(), profileService);

        final CourseService courseService = CourseService.getInstance(CourseRepository.getInstance());

        final GroupService groupService = GroupService.getInstance(
                GroupRepository.getInstance(), studentService, courseService
        );

        groupService.createRandomGroup(1, 1).forEach(System.out::println);

    }
}
