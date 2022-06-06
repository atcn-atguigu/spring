package com.atguigu.spring5.aop.jdk.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    public int add(int a, int b) {
        System.out.println("UserDaoImpl.add()方法执行了");
        return a + b;
    }

    public String update(String id) {
        return id;
    }
}
