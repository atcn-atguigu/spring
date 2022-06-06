### IOC操作Bean管理（基于注解方式）- 完全注解开发

1、创建配置类，替代xml配置文件

```java
@Configuration // 作为配置类，替代xml配置文件
//@ComponentScan(basePackages = {"com.atguigu.spring5.dependencyInjection.annotations.dao, com.atguigu.spring5.dependencyInjection.annotations.service"})
@ComponentScan(basePackages = {"com.atguigu.spring5"})
public class SpringConfig {
}


@Test
public void testAutowired() {
  // 加载配置类
  ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
  BookService bookService = context.getBean("bookService", BookService.class);
  bookService.add();
}
```

