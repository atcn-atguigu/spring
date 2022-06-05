### IOC操作Bean管理（xml）- Bean引入外部XML属性文件

1、直接配置数据库信息
	1）配置连接池
	2）引入druid连接池依赖

```xml
<!--maven依赖：数据库连接池druid-->
<dependency>
  <groupId>com.alibaba</groupId>
  <artifactId>druid</artifactId>
  <version>1.1.10</version>
</dependency>
```

```xml
<!--直接配置连接池-->
<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
  <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
  <property name="url" value="jdbc:mysql://localhost:3306/userDb"/>
  <property name="username" value="root"/>
  <property name="password" value="root"/>
</bean>
```

2、引入外部属性文件配置数据库连接池
	1）创建外部属性文件，properties文件，内容如下

```properties
jdbc.driverClassName="com.mysql.jdbc.Driver"
jdbc.url="jdbc:mysql://localhost:3306/userDb"
jdbc.username="root"
jdbc.password="root"
```

​	2）把外部properties属性文件引入到spring的bean配置xml中
​	*需要引入context名称空间

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
```

​	*在spring配置文件中使用context标签引入外部属性文件，使用${}表达式读取外部属性文件的值

```xml
<!--
    1. 引入外部属性文件，使用引入context命名空间的context标签
    2. 使用${}表达式读取外部属性文件的值
-->
<context:property-placeholder location="classpath:jdbc.properties"/>
<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
  <property name="driverClassName" value="${jdbc.driverClassName}"/>
  <property name="url" value="${jdbc.url}"/>
  <property name="username" value="${jdbc.username}"/>
  <property name="password" value="${jdbc.password}"/>
</bean>
```



