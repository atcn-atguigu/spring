package com.atguigu.spring5.transanctionalAnnotations.service;

import com.atguigu.spring5.transanctionalAnnotations.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
//@Transactional(propagation = Propagation.REQUIRED) // 默认值
//@Transactional(propagation = Propagation.REQUIRES_NEW)
//@Transactional(isolation = Isolation.READ_UNCOMMITTED)
//@Transactional(isolation = Isolation.READ_COMMITTED)
//@Transactional(isolation = Isolation.REPEATABLE_READ)
//@Transactional(isolation = Isolation.SERIALIZABLE)
//@Transactional(timeout = -1)
//@Transactional(timeout = 10)
//@Transactional(readOnly = false) // 默认值
//@Transactional(readOnly = true)
//@Transactional(rollbackFor = ArithmeticException.class)
//@Transactional(noRollbackFor = ArithmeticException.class)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, timeout = -1, readOnly = false) // 多个默认值一起写的写法
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
