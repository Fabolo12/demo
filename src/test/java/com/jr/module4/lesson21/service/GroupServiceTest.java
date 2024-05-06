package com.jr.module4.lesson21.service;

import com.jr.module4.lesson21.model.Course;
import com.jr.module4.lesson21.model.Student;
import com.jr.module4.lesson21.model.StudentGroup;
import com.jr.module4.lesson21.repository.GroupRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class GroupServiceTest {

    private GroupService target;

    @Mock
    private GroupRepository groupRepository;

    @Mock
    private StudentService studentService;

    @Mock
    private CourseService courseService;

    @BeforeEach
    void setUp() {
        target = GroupService.getInstance(groupRepository, studentService, courseService);
    }

    @Test
    void createRandomGroup() {
        final int studentCount = 1;

        Mockito.when(studentService.createRandomStudent(studentCount))
                .thenReturn(Collections.singletonList(new Student()));
        Mockito.when(courseService.createRandomCourse())
                .thenReturn(new Course());
        Mockito.doAnswer(invocationOnMock -> {
            final StudentGroup studentGroup = invocationOnMock.getArgument(0);
            studentGroup.setId(UUID.randomUUID());
            return null;
        }).when(groupRepository).save(Mockito.any(StudentGroup.class));


        final List<StudentGroup> actualList = target.createRandomGroup(1, studentCount);

        Assertions.assertEquals(1, actualList.size());

        final StudentGroup actualGroup = actualList.get(0);
        Assertions.assertNotNull(actualGroup.getId());
        Assertions.assertNotNull(actualGroup.getName());
        Assertions.assertEquals(LocalDate.now(), actualGroup.getStarted());
        Assertions.assertEquals(1, actualGroup.getStudents().size());
        Assertions.assertEquals(1, actualGroup.getCourses().size());

        Mockito.verify(groupRepository, Mockito.times(2))
                .save(Mockito.any(StudentGroup.class));
    }
}