package com.atguigu.spring5.jdbctemplate.service;

import com.atguigu.spring5.jdbctemplate.dao.BookDao;
import com.atguigu.spring5.jdbctemplate.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    // service类里注入dao
    @Autowired
    private BookDao bookDao;

    // 添加的方法
    public int addBook(Books books) {
        return bookDao.add(books);
    }

    public int updateBook(Books books) {
        return bookDao.update(books);
    }

    public int deleteBook(Books books) {
        return bookDao.delete(books);
    }

    public int queryBookTableCount() {
        return bookDao.queryTableCount();
    }

    public Books queryBookById(Books books) {
        return bookDao.queryById(books);
    }

    public List<Books> queryBookByName(Books books) {
        return bookDao.queryByName(books);
    }

    public List<Books> queryBookAll() {
        return bookDao.queryAll();
    }
}
