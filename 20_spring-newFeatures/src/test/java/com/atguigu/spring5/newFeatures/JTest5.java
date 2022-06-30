package com.atguigu.spring5.newFeatures;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) //指定单元测试框架版本
@ContextConfiguration("classpath:spring.xml") //加载配置文件
public class JTest5 {

    @Autowired  //这里可以直接注入bean对象来使用了
    private User user;

    @Test
    public void printUser() {
        System.out.println(user);
    }

}
