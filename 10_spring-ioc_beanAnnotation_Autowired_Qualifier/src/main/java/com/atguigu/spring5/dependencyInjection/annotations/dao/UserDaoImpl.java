package com.atguigu.spring5.dependencyInjection.annotations.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    public void add() {
        System.out.println("UserDaoImpl.add() - user dao add.....");
    }
}
