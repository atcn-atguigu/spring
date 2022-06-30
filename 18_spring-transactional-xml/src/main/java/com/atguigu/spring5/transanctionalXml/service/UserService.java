package com.atguigu.spring5.transanctionalXml.service;

import com.atguigu.spring5.transanctionalXml.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // 注入dao
    @Autowired
    private UserDao userDao;

    // Lucy给Mary转账的方法
    public void moveMoney() {
        // Lucy少100
        userDao.reduceMoney();

        // 模拟异常
        int i = 10/0;

        // Mary多100
        userDao.addMoney();
    }
}
