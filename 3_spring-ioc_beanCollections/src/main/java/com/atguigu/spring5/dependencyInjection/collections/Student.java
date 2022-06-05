package com.atguigu.spring5.dependencyInjection.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {

    // 1 - Array数组类型属性
    private String[] studentName;
    private String[] courses;

    // 2 - List集合类型属性
    private List<String> list;

    // 3 - Map集合类型属性
    private Map<String, String> maps;

    // 4 - Set集合类型属性
    private Set<String> sets;

    public void setStudentName(String[] studentName) {
        this.studentName = studentName;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName=" + Arrays.toString(studentName) +
                ", courses=" + Arrays.toString(courses) +
                ", list=" + list +
                ", maps=" + maps +
                ", sets=" + sets +
                '}';
    }
}
