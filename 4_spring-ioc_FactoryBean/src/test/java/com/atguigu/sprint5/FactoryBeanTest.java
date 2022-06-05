package com.atguigu.sprint5;

import com.atguigu.spring5.dependencyInjection.factoryBean.Course;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {

    @Test
    public void testFactoryBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("FactoryBean.xml");

        // expected to be of type 'com.atguigu.spring5.dependencyInjection.factoryBean.MyBean' but was actually of type 'com.atguigu.spring5.dependencyInjection.factoryBean.Course'
//        MyBean myBean = context.getBean("myBean", MyBean.class);
//        System.out.println(myBean);

        // 返回类型为Course，bean类为MyBean。
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }
}
