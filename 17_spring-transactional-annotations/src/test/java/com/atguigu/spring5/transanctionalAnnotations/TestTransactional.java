package com.atguigu.spring5.transanctionalAnnotations;


import com.atguigu.spring5.transanctionalAnnotations.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransactional {

    @Test
    public void testTransactionalAnnotations() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        UserService userService = context.getBean("userService", UserService.class);
        // 完成转账的方法测试
        userService.moveMoney();
    }
}
