package com.jr.module4.lesson21.controller;

import com.jr.module4.lesson21.repository.CourseRepository;
import com.jr.module4.lesson21.repository.GroupRepository;
import com.jr.module4.lesson21.repository.ProfileRepository;
import com.jr.module4.lesson21.repository.StudentRepository;
import com.jr.module4.lesson21.service.CourseService;
import com.jr.module4.lesson21.service.GroupService;
import com.jr.module4.lesson21.service.ProfileService;
import com.jr.module4.lesson21.service.StudentService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.PrintWriter;

@WebServlet(name = "StudentController", value = "/lesson21/students")
public class StudentController extends HttpServlet {

    private static final ProfileService profileService = ProfileService.getInstance(ProfileRepository.getInstance());

    private static final StudentService studentService = StudentService.getInstance(StudentRepository.getInstance(), profileService);

    private static final CourseService courseService = CourseService.getInstance(CourseRepository.getInstance());

    private static final GroupService groupService = GroupService.getInstance(
            GroupRepository.getInstance(), studentService, courseService
    );

    @SneakyThrows
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) {
        try (final PrintWriter writer = resp.getWriter()) {
            groupService.createRandomGroup(1, 1).forEach(item -> {
                writer.write(item.toString());
                writer.write("\n");
            });

        }
    }
}