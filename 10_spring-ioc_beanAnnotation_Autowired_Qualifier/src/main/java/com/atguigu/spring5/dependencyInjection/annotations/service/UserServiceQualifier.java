package com.atguigu.spring5.dependencyInjection.annotations.service;

import com.atguigu.spring5.dependencyInjection.annotations.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceQualifier {

    // service上调用dao，需要定义dao类型属性
    // 注意这里不需要添加setter方法
    @Autowired // 根据类型进行注入：byType
    @Qualifier(value="userDaoImpl2") // 假如有多个实现类的时候，指定名称选择对应实现类来注入指定实现类类依赖对象
    private UserDao userDao;

    public void add() {
        System.out.println("UserServiceQualifier.add() - user service add.....");
        // 为了体现属性注入效果，在这里打印dao方法
        userDao.add();
    }
}
