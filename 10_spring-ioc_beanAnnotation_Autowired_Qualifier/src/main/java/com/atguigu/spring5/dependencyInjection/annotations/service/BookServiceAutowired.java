package com.atguigu.spring5.dependencyInjection.annotations.service;

import com.atguigu.spring5.dependencyInjection.annotations.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceAutowired {

    // service上调用dao，需要定义dao类型属性
    // 注意这里不需要添加setter方法
    @Autowired // 根据类型进行注入：byType
    private BookDao bookDao;

    public void add() {
        System.out.println("BookServiceAutowired.add() - book service add.....");
        // 为了体现属性注入效果，在这里打印dao方法
        bookDao.add();
    }
}
