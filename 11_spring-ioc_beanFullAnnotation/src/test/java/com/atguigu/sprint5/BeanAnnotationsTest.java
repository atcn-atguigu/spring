package com.atguigu.sprint5;

import com.atguigu.spring5.dependencyInjection.annotations.config.SpringConfig;
import com.atguigu.spring5.dependencyInjection.annotations.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanAnnotationsTest {

    @Test
    public void testAutowired() {
        // 加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.add();
    }
}