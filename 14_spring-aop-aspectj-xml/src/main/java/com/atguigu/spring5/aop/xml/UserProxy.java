package com.atguigu.spring5.aop.xml;

//增强的类
public class UserProxy {
    public void before() {
        System.out.println("UserProxy.before()...前置通知");
    }
}
