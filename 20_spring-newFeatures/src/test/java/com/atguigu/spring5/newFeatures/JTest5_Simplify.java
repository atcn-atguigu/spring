package com.atguigu.spring5.newFeatures;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ExtendWith(SpringExtension.class) //指定单元测试框架版本
//@ContextConfiguration("classpath:spring.xml") //加载配置文件
@SpringJUnitConfig(locations = "classpath:spring.xml") // 对于Junit5，可以使用一个复合注解替代上面两个注解完成整合（简写法）
public class JTest5_Simplify {

    @Autowired  //这里可以直接注入bean对象来使用了
    private User user;

    @Test
    public void printUser() {
        System.out.println(user);
    }

}
