package com.atguigu.sprint5;

import com.atguigu.spring5.aop.xml.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    @Test
    public void testAopXML() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}
