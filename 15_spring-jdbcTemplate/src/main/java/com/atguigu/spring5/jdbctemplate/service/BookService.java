package com.atguigu.spring5.jdbctemplate.service;

import com.atguigu.spring5.jdbctemplate.dao.BookDao;
import com.atguigu.spring5.jdbctemplate.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    // service类里注入dao
    @Autowired
    private BookDao bookDao;

    // 添加的方法
    public void addBook(Books books) {
        bookDao.add(books);
    }
}
