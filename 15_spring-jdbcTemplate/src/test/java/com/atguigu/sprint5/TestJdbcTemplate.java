package com.atguigu.sprint5;

import com.atguigu.spring5.jdbctemplate.entity.Books;
import com.atguigu.spring5.jdbctemplate.service.BookService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Junit4指定按顺序的测试用例执行顺序，ref: https://www.softwaretestinghelp.com/juni-test-execution-order/
public class TestJdbcTemplate {

    @Test
    public void testJdbcTemplate1_INSERT() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Books books = new Books();
        books.setBookName("诗经");
        books.setBookCounts(20);
        books.setDetail("中国最早的诗歌总集");
        bookService.addBook(books);
    }

    @Test
    public void testJdbcTemplate2_Update() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        // 通过书名拿到对应Id的所有书籍列表
        Books books = new Books();
        books.setBookName("诗经");
        List<Books> booksList = bookService.queryBookByName(books);
        // 将第一条记录更新书籍信息
        booksList.get(0).setBookName("乾坤大挪移");
        booksList.get(0).setBookCounts(7);
        booksList.get(0).setDetail("至第七层者实是古往今来第一人");
        bookService.updateBook(booksList.get(0));
    }

    @Test
    public void testJdbcTemplate3_Delete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        // 通过书名拿到对应Id的所有书籍列表
        Books books = new Books();
        books.setBookName("乾坤大挪移");
        List<Books> booksList = bookService.queryBookByName(books);
        for (Books book: booksList) {
            // 删除同名所有书籍
            bookService.deleteBook(book);
        }
    }

    @Test
    public void testJdbcTemplate4_QueryBookTableCount() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.queryBookTableCount();
    }

    @Test
    public void testJdbcTemplate5_QueryBookById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Books books = new Books();
        books.setBookID(1);
        System.out.println("数据库SELECT查询操作，testJdbcTemplate5_QueryBookById()：" + bookService.queryBookById(books));
    }

    @Test
    public void testJdbcTemplate6_QueryBookByName() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Books books = new Books();
        books.setBookName("Linux");
        System.out.println("数据库SELECT查询操作，testJdbcTemplate6_QueryBookByName()：" + bookService.queryBookByName(books));
    }

    @Test
    public void testJdbcTemplate7_QueryBookAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println("数据库SELECT查询操作，testJdbcTemplate7_QueryBookAll()：" + bookService.queryBookAll());
    }
}
