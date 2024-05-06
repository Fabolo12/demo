package com.jr.module4.lesson21.model;

import com.jr.module4.HibernateFactoryUtil;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class StudentGroup {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private LocalDate started;

    @OneToMany(mappedBy = "group", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Student> students = new HashSet<>();

    @ManyToMany
    private Set<Course> courses = new HashSet<>();

    public void addCourse(final Course course) {
        courses.add(course);
        course.getStudentGroups().add(this);
    }

    public void addStudent(final Student student) {
        students.add(student);
        student.setGroup(this);
    }
}
