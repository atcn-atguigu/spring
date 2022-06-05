package com.atguigu.sprint5;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanExternalConfigTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanDruid.xml");
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource);
    }
}