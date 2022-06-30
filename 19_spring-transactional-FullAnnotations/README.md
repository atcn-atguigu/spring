### 事务操作（完全注解声明式事务管理）

1、创建配置类，使用配置类替代xml配置文件

```java
@Configuration
@ComponentScan(basePackages = "com.atguigu.spring5.transanctionalFullAnnotations") //组建扫描
@EnableTransactionManagement //开启事务
public class SpringTxConfig {

    //创建数据库连接池
    @Bean
    public DruidDataSource getDruidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/spring_book?useSSL=true&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
        return druidDataSource;
    }

    //创建JdbcTemplate对象
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //传入创建的DataSource：到ioc容器中根据类型找到dataSource，这里不直接调用get方法了
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    //创建事务管理器
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
```

2、测试类

```java
@Test
public void testTransactionalFullAnnotations() {
  ApplicationContext context = new AnnotationConfigApplicationContext(SpringTxConfig.class);
  UserService userService = context.getBean("userService", UserService.class);
  // 完成转账的方法测试
  userService.moveMoney();
}
```



