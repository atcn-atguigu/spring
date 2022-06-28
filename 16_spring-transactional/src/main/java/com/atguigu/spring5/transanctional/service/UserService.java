package com.atguigu.spring5.transanctional.service;

import com.atguigu.spring5.transanctional.dao.UserDao;
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

        // Mary多100
        userDao.addMoney();
    }

}
