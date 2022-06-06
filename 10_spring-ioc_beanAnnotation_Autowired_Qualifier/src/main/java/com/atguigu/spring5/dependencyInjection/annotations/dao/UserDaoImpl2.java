package com.atguigu.spring5.dependencyInjection.annotations.dao;

import org.springframework.stereotype.Repository;

@Repository(value="userDaoImpl2")
public class UserDaoImpl2 implements UserDao {

    public void add() {
        System.out.println("UserDaoImpl2.add() - user dao add.....");
    }
}
