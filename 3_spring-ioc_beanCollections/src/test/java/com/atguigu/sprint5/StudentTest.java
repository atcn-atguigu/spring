package com.atguigu.sprint5;

import com.atguigu.spring5.dependencyInjection.collections.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {

    @Test
    public void testAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Student.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }
}
