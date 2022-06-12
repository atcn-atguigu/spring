package com.atguigu.spring5.jdbctemplate.dao;

import com.atguigu.spring5.jdbctemplate.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    // dao类里注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 添加书籍
    public void add(Books books) {
        // 1. 创建sql语句, ?表示占位符，可被jdbcTemplate参数形式替换
        String sql = "INSERT INTO spring_book.t_books (bookName, bookCounts, detail) VALUE (?,?,?)";

        // 2。 调用方法实现，返回影响行数
        // 写法1.
//        int update = jdbcTemplate.update(sql, books.getBookName(), books.getBookCounts(), books.getDetail());

        // 写法2.
        Object[] args = {books.getBookName(), books.getBookCounts(), books.getDetail()};
        int update = jdbcTemplate.update(sql, args);

        System.out.println(update);
    }
}
