package com.atguigu.spring5.dependencyInjection.internalBean.entity;

public class Department {

    private String departmentName;

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                '}';
    }
}
