package com.atguigu.sprint5;

import com.atguigu.spring5.transanctional.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransactional {

    @Test
    public void testTransactional() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        UserService userService = context.getBean("userService", UserService.class);
        // 完成转账的方法测试
        userService.moveMoney();
    }
}
