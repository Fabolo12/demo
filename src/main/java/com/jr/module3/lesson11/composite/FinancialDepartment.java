package com.jr.module3.lesson11.composite;

public class FinancialDepartment implements Department {

    private final int id;

    public FinancialDepartment(final int id) {
        this.id = id;
    }

    @Override
    public void printDepartmentName() {
        System.out.println(id + " FinancialDepartment");
    }
}
