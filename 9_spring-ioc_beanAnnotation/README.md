### IOC操作Bean管理（基于注解方式）

1、什么是注解？
	1）注解是代码的特殊标记，格式：@注解名称（属性名称=属性值，属性名称=属性值...）
	2）注解可以在什么地方用：类、属性、方法
	3）使用注解的目的：简化xml配置，更为优雅

2、Spring针对Bean管理中创建对象提供注解，下面的注解都是功能通用的，只是便于开发人员阅读识别
	1）@Component - 表示容器管理创建该对象
	2）@Service - 用于servic业务逻辑层
	3）@Controller - 用于Web入口
	4）@Repository - 用于dao层

3、基于注解方式实现对象创建
	1）第一步 使用注解需引入依赖：spring-aop

```xml
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-aop</artifactId>
  <version>5.3.3</version>
</dependency>
```

​	2）第二步 开启组件扫描

```xml
<!--开启组件扫面
        方式1：如果扫描多个包， 多个包使用逗号隔开
        方式2：扫描包上层目录
    -->
<!--    <context:component-scan base-package="com.atguigu.spring5.dependencyInjection.annotations.dao, com.atguigu.spring5.dependencyInjection.annotations.service"/>-->
<context:component-scan base-package="com.atguigu.spring5.dependencyInjection.annotations"/>
```

​	3）第三步 创建类，在类上添加创建对象的注解

```java
@Component // 写法1，不加括号内容，默认值类名首字母小写
//@Component(value="userService") // 写法2，等同于<bean id="userService class=".."/>
public class UserService {
```

4、开启组件扫描的细节问题：include/exclude 用法
	1）include

```xml
<!--开启组件扫面：include参数
  use-default-filters="false" - 表示步使用默认filter，自己配置filter
-->
<context:component-scan base-package="com.atguigu.spring5.dependencyInjection.annotations" use-default-filters="false">
  <!--只扫描带@Controller的类-->
  <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
</context:component-scan>
```

​	2）exclude

```xml
<!--开启组件扫面：exclude参数-->
<context:component-scan base-package="com.atguigu.spring5.dependencyInjection.annotations">
  <!--只扫描带@Controller的类-->
  <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
</context:component-scan>
```

