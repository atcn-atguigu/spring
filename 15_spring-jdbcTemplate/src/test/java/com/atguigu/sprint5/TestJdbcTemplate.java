package com.atguigu.sprint5;

import com.atguigu.spring5.jdbctemplate.entity.Books;
import com.atguigu.spring5.jdbctemplate.service.BookService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Junit4指定按顺序的测试用例执行顺序，ref: https://www.softwaretestinghelp.com/juni-test-execution-order/
public class TestJdbcTemplate {

    @Test
    public void testJdbcTemplate_a1_INSERT() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Books books = new Books();
        books.setBookName("诗经");
        books.setBookCounts(20);
        books.setDetail("中国最早的诗歌总集");
        bookService.addBook(books);
    }

    @Test
    public void testJdbcTemplate_a2_Update() {
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
    public void testJdbcTemplate_a3_Delete() {
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
    public void testJdbcTemplate_a4_QueryBookTableCount() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.queryBookTableCount();
    }

    @Test
    public void testJdbcTemplate_a5_QueryBookById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Books books = new Books();
        books.setBookID(1);
        System.out.println("数据库SELECT查询操作，testJdbcTemplate5_QueryBookById()：" + bookService.queryBookById(books));
    }

    @Test
    public void testJdbcTemplate_a6_QueryBookByName() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Books books = new Books();
        books.setBookName("Linux");
        System.out.println("数据库SELECT查询操作，testJdbcTemplate6_QueryBookByName()：" + bookService.queryBookByName(books));
    }

    @Test
    public void testJdbcTemplate_a7_QueryBookAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println("数据库SELECT查询操作，testJdbcTemplate7_QueryBookAll()：" + bookService.queryBookAll());
    }

    @Test
    public void testJdbcTemplate_a8_batchAddBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> batchArgs = new ArrayList<Object[]>();
        Object[] o1 = {"九阳神功", "99", "絕頂之內功心法，威力可能與另一路少林無上神功《易筋經》難分上下"};
        Object[] o2 = {"九阴真经", "9", "武林中眾人夢寐以求的至寶，也是金庸小說最絕頂的武功之一"};
        Object[] o3 = {"双剑合璧", "22", "一般用来指两个各有特色的人或集体，在配合时能够互相产生极大的辅助作用"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchAddBook(batchArgs);
    }

    @Test
    public void testJdbcTemplate_a9_batchUpdateBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        // 通过书名拿到对应Id的所有书籍列表的第一个
        List<Object[]> batchArgs = new ArrayList<Object[]>();
        Object[] o1 = {"九阳神功", "199", "絕頂之內功心法，威力可能與另一路少林無上神功《易筋經》難分上下", bookService.getBookIdByBookName(new Books("九阳神功"))};
        Object[] o2 = {"九阴真经", "19", "武林中眾人夢寐以求的至寶，也是金庸小說最絕頂的武功之一", bookService.getBookIdByBookName(new Books("九阴真经"))};
        Object[] o3 = {"双剑合璧", "122", "一般用来指两个各有特色的人或集体，在配合时能够互相产生极大的辅助作用", bookService.getBookIdByBookName(new Books("双剑合璧"))};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchUpdateBook(batchArgs);
    }

    @Test
    public void testJdbcTemplate_b1_batchDeleteBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbctemplate.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        // 通过书名拿到对应Id的所有书籍列表的第一个
        List<Object[]> batchArgs = new ArrayList<Object[]>();
        Object[] o1 = {bookService.getBookIdByBookName(new Books("九阳神功"))};
        Object[] o2 = {bookService.getBookIdByBookName(new Books("九阴真经"))};
        Object[] o3 = {bookService.getBookIdByBookName(new Books("双剑合璧"))};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchDeleteBook(batchArgs);
    }
}
