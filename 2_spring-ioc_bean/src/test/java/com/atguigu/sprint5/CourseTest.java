package com.atguigu.sprint5;

import com.atguigu.spring5.dependencyInjection.externalBean.service.CourseService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CourseTest {

    @Test
    public void testCourseExternalBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("courseExternalBean.xml");
        CourseService courseService = context.getBean("courseService", CourseService.class);
        courseService.add();
    }
}
