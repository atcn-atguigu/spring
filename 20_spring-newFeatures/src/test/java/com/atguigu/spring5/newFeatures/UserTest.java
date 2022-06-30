package com.atguigu.spring5.newFeatures;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class UserTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserTest.class);

    @Test
    public void testAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User user = context.getBean("user", User.class);
        System.out.println("1 -- " + user.toString());
        LOGGER.info("2 -- " + user.toString());
        LOGGER.info("Hello log4j2");
        LOGGER.warn("Hello log4j2");
        user.add();
    }

    //Spring5核心容器支持**函数式风格（GenericApplicationContext）
    @Test
    public void testGenericApplicationContext() {
        //1、创建GenericApplicationContext对象
        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        //2、调用context的方法对象注册
        genericApplicationContext.refresh(); // 先清空

        // Option1: 不指定beanName
        genericApplicationContext.registerBean(User.class, () -> new User()); // 再注册
        // Option2：指定beanName
        genericApplicationContext.registerBean("user2", User.class, () -> new User()); // 再注册

        //3、获取在spring注册的对象
        // Option1: 不指定beanName，则需要写全路径
        User user1 = (User) genericApplicationContext.getBean("com.atguigu.spring5.newFeatures.User");
        // Option2: 指定beanName，则可以直接通过beanName获取对象
        User user2 = (User) genericApplicationContext.getBean("user2");
        System.out.println(user1);
        System.out.println(user2);
    }
}
