package com.atguigu.sprint5;

import com.atguigu.spring5.jdbctemplate.entity.Books;
import com.atguigu.spring5.jdbctemplate.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJdbcTemplate {

    @Test
    public void testJdbcTemplate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Books books = new Books();
        books.setBookName("诗经");
        books.setBookCounts(20);
        books.setDetail("中国最早的诗歌总集");
        bookService.addBook(books);
    }
}
