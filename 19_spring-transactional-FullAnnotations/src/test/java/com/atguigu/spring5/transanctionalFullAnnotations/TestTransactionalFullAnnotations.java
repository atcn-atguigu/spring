package com.atguigu.spring5.transanctionalFullAnnotations;


import com.atguigu.spring5.transanctionalFullAnnotations.config.SpringTxConfig;
import com.atguigu.spring5.transanctionalFullAnnotations.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestTransactionalFullAnnotations {

    @Test
    public void testTransactionalFullAnnotations() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringTxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        // 完成转账的方法测试
        userService.moveMoney();
    }
}
