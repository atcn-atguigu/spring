package com.atguigu.spring5.aop.annotation;

import org.springframework.stereotype.Component;

//需要被增强的类
@Component
public class User {
    public void add() {
//        int i = 10/0; // 这里用于测试抛出异常情况
        System.out.println("User.add()...");
    }
}
