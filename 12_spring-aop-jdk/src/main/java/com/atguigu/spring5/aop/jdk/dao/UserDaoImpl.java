package com.atguigu.spring5.aop.jdk.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    public int add(int a, int b) {
        System.out.println("UserDaoImpl.add()方法执行了");
        return a + b;
    }

    public void sendMsg(String msg) {
        System.out.println("UserDaoImpl.sendMsg()方法执行了，内容为：" + msg);
    }
}
