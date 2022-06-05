package com.atguigu.sprint5;

import com.atguigu.spring5.dependencyInjection.collections.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookTest {

    @Test
    public void testBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Book.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }
}
