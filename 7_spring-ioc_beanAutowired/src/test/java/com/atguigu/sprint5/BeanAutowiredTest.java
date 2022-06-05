package com.atguigu.sprint5;

import com.atguigu.spring5.dependencyInjection.autowired.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAutowiredTest {

    @Test
    public void testBeanOriginalApproach() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAutowired.xml");
        Employee emp = context.getBean("emp", Employee.class);
        System.out.println(emp);
    }
}