package com.atguigu.sprint5;

import com.atguigu.spring5.dependencyInjection.beanLifeCycle.Orders;
import com.atguigu.spring5.dependencyInjection.beanLifeCycle.Orders3;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleTest {

    @Test
    public void testBeanLifeCycle() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第四步 获取创建的bean实例对象");
        System.out.println(orders);
        // 手动让bean实例销毁，来调用destroy方法
        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test
    public void testBeanLifeCyclePostProcessor() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCyclePostProcessor.xml");

        /**
         * getBean()方法读取【任意一个】配置文件里的对象，所有配置文件里的对象皆被初始化
         */
        Orders3 orders3 = context.getBean("orders3", Orders3.class);
        System.out.println("所有通用：第四步 获取创建的bean实例对象");
        System.out.println(orders3);

//        MyBeanPost myBeanPost = context.getBean("myBeanPost", MyBeanPost.class);
//        System.out.println("第四步 获取创建的bean实例对象");
//        System.out.println(myBeanPost);

        // 手动让bean实例销毁，来调用destroy方法
        ((ClassPathXmlApplicationContext) context).close();
    }
}
