package com.atguigu.sprint5;

import com.atguigu.spring5.dependencyInjection.beanScope.Book;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeTest {

    @Test
    public void testBeanScopeDefault() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanScope.xml");
        Book book1 = context.getBean("bookScopeDefault", Book.class);
        Book book2 = context.getBean("bookScopeDefault", Book.class);
        System.out.println(book1);
        System.out.println(book2);
        Assert.assertEquals("检查book1和book2是否单例同一个对象", book1, book2);
    }

    @Test
    public void testBeanScopeSingleton() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanScope.xml");
        Book book1 = context.getBean("bookScopeSingleton", Book.class);
        Book book2 = context.getBean("bookScopeSingleton", Book.class);
        System.out.println(book1);
        System.out.println(book2);
        Assert.assertEquals("检查book1和book2是否单例同一个对象", book1, book2);
    }

    @Test
    public void testBeanScopePrototype() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanScope.xml");
        Book book1 = context.getBean("bookScopePrototype", Book.class);
        Book book2 = context.getBean("bookScopePrototype", Book.class);
        System.out.println(book1);
        System.out.println(book2);
        Assert.assertNotEquals("检查book1和book2是否多实例不同对象", book1, book2);
    }
}
