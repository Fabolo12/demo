package com.jr.module3.lesson11.composite;

public class Main {
    public static void main(String[] args) {
        createSystem().printDepartmentName();
    }

    private static Department createSystem() {
        final Department financialDepartment1 = new FinancialDepartment(11);
        final Department salesDepartment1 = new SalesDepartment(11);
        final Department salesDepartment2 = new SalesDepartment(11);
        final HeadDepartment headDepartment1 = new HeadDepartment(1);
        headDepartment1.addDepartment(financialDepartment1);
        headDepartment1.addDepartment(salesDepartment1);
        headDepartment1.addDepartment(salesDepartment2);

        final Department financialDepartment2 = new FinancialDepartment(21);
        final Department salesDepartment3 = new SalesDepartment(21);
        final HeadDepartment headDepartment2 = new HeadDepartment(2);
        headDepartment2.addDepartment(financialDepartment2);
        headDepartment2.addDepartment(salesDepartment3);

        final HeadDepartment headDepartment0 = new HeadDepartment(0);
        headDepartment0.addDepartment(headDepartment1);
        headDepartment0.addDepartment(headDepartment2);

        return headDepartment0;
    }
}
