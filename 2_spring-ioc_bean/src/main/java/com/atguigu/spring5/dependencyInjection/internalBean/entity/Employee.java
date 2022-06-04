package com.atguigu.spring5.dependencyInjection.internalBean.entity;

public class Employee {

    private String employeeName;
    private String gender;
    // 员工属于某一个部门，使用对象形式表示
    private Department department;

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // 生成getter方法：主要作用于第二种级联的写法需要getter
    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", gender='" + gender + '\'' +
                ", department=" + department +
                '}';
    }
}
