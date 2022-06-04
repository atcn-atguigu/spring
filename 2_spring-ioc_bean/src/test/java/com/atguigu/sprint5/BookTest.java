package com.atguigu.sprint5;

import com.atguigu.spring5.dependencyInjection.BookConstructorInjection;
import com.atguigu.spring5.dependencyInjection.BookNullValueInjection;
import com.atguigu.spring5.dependencyInjection.BookSetterInjection;
import com.atguigu.spring5.dependencyInjection.BookSpecialCharactersInjection;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookTest {

    @Test
    public void testBookSetterInjection() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bookSetterInjection.xml");
        BookSetterInjection book = context.getBean("book", BookSetterInjection.class);
        System.out.println(book);
    }

    @Test
    public void testBookConstructorInjection() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bookConstructorInjection.xml");
        BookConstructorInjection book = context.getBean("book", BookConstructorInjection.class);
        System.out.println(book);
    }

    @Test
    public void testBookNullInjection() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bookNullValueInjection.xml");
        BookNullValueInjection book = context.getBean("book", BookNullValueInjection.class);
        System.out.println(book);
    }

    @Test
    public void testBookSpecialCharactersInjection() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bookSpecialCharactersInjection.xml");
        BookSpecialCharactersInjection book = context.getBean("book", BookSpecialCharactersInjection.class);
        System.out.println(book);
    }
}
