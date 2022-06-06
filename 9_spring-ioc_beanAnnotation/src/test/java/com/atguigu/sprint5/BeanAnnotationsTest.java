package com.atguigu.sprint5;

import com.atguigu.spring5.dependencyInjection.annotations.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAnnotationsTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAnnotations.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}