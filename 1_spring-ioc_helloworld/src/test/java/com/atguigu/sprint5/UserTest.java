package com.atguigu.sprint5;

import com.atguigu.spring5.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void testAdd() {
        // Option 1
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // Option 2
        BeanFactory context = new ClassPathXmlApplicationContext("spring.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }
}
