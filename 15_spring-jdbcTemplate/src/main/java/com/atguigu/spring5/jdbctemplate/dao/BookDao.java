package com.atguigu.spring5.jdbctemplate.dao;

import com.atguigu.spring5.jdbctemplate.entity.Books;

public interface BookDao {
    // 添加书籍
    void add(Books books);
}
