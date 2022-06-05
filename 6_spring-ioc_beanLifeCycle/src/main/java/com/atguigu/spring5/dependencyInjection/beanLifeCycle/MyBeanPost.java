package com.atguigu.spring5.dependencyInjection.beanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPost implements BeanPostProcessor {

    // 后置处理器 - 初始化前
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization() - 在bean初始化之前执行的方法");
        return bean;
    }

    // 后置处理器 - 初始化后
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization() - 在bean初始化之后执行的方法");
        return bean;
    }
}
