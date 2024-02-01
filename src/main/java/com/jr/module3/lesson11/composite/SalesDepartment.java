package com.jr.module3.lesson11.composite;

public class SalesDepartment implements Department {
    private final int id;

    public SalesDepartment(final int id) {
        this.id = id;
    }

    @Override
    public void printDepartmentName() {
        System.out.println(id + " SalesDepartment");
    }
}
