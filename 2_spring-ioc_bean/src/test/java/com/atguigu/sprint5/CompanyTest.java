package com.atguigu.sprint5;

import com.atguigu.spring5.dependencyInjection.internalBean.entity.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CompanyTest {

    @Test
    public void testCompanyInternalBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("companyInternalBean.xml");
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee);
    }

    @Test
    public void testCompanyChainProp1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("companyChainProp1.xml");
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee);
    }

    @Test
    public void testCompanyChainProp2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("companyChainProp2.xml");
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee);
    }
}
