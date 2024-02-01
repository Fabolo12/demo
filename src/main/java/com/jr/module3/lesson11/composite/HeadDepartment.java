package com.jr.module3.lesson11.composite;

import java.util.ArrayList;
import java.util.List;

public class HeadDepartment implements Department {
    private final List<Department> childDepartments;

    private final int id;

    public HeadDepartment(final int id) {
        this.id = id;
        this.childDepartments = new ArrayList<>();
    }

    @Override
    public void printDepartmentName() {
        System.out.println(id + " HeadDepartment");
        childDepartments.forEach(Department::printDepartmentName);
    }

    public void addDepartment(Department department) {
        childDepartments.add(department);
    }

    public void removeDepartment(Department department) {
        childDepartments.remove(department);
    }
}
