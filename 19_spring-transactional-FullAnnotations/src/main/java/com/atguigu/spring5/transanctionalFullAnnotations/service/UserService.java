package com.atguigu.spring5.transanctionalFullAnnotations.service;

import com.atguigu.spring5.transanctionalFullAnnotations.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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
