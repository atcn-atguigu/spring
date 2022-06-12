package com.atguigu.spring5.jdbctemplate.dao;

import com.atguigu.spring5.jdbctemplate.entity.Books;

import java.util.List;

public interface BookDao {
    // 添加书籍
    int add(Books books);

    // 修改书籍
    int update(Books books);

    // 删除书籍
    int delete(Books books);

    // 查询表记录数
    int queryTableCount();

    // 通过书籍id查询书籍 - 最多返回一个值（书籍）
    Books queryById(Books books);

    // 通过书籍name查询书籍 - 返回一个或多个值（书籍集合）
    List<Books> queryByName(Books books);

    // 查询所有书籍 - 返回对象（书籍集合）
    List<Books> queryAll();
}
