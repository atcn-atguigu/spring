package com.atguigu.spring5.dependencyInjection.factoryBean;

import org.springframework.beans.factory.FactoryBean;

// 定义数据MyBean类对象，而返回类型使用Course类对象，重写接口Factory的getObject()方法
public class MyBean implements FactoryBean<Course> {


    public Course getObject() throws Exception {
        // 手动设置一个course值后返回
        Course course = new Course();
        course.setCourseName("abc");
        return course;
    }

    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return false;
    }
}
