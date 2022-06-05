package com.atguigu.spring5.dependencyInjection.autowired;

public class Employee {

    private Department department;

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "department=" + department +
                '}';
    }
}
