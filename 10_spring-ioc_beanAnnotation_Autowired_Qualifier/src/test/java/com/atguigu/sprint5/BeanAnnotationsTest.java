package com.atguigu.sprint5;

import com.atguigu.spring5.dependencyInjection.annotations.service.BookServiceAutowired;
import com.atguigu.spring5.dependencyInjection.annotations.service.UserServiceQualifier;
import com.atguigu.spring5.dependencyInjection.annotations.service.ValueNormalDataInjectionService;
import com.atguigu.spring5.dependencyInjection.annotations.service.WorkerServiceResource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAnnotationsTest {

    @Test
    public void testAutowired() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAnnotations.xml");
        BookServiceAutowired bookServiceAutowired = context.getBean("bookServiceAutowired", BookServiceAutowired.class);
        bookServiceAutowired.add();
    }

    @Test
    public void testQualifier() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAnnotations.xml");
        UserServiceQualifier userServiceQualifier = context.getBean("userServiceQualifier", UserServiceQualifier.class);
        userServiceQualifier.add();
    }

    @Test
    public void testResource() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAnnotations.xml");
        WorkerServiceResource workerServiceResource = context.getBean("workerServiceResource", WorkerServiceResource.class);
        workerServiceResource.add();
    }

    @Test
    public void testValue() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAnnotations.xml");
        ValueNormalDataInjectionService valueNormalDataInjectionService = context.getBean("valueNormalDataInjectionService", ValueNormalDataInjectionService.class);
        valueNormalDataInjectionService.valueTest();
    }
}