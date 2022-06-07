### AOP（术语）

1、连接点 - 接口类里面的**哪些方法可以被增强**，这些方法被称为连接点

2、切入点 - **实际真正被增强的方法**，被称为切入点

3、通知（增强）
	1）实际增强的逻辑部分称为通知（增强）
	2）通知有多种类型
		a）前置通知 - 前置增强方法，切入点之前执行
		b）后置通知 - 后置增强方法，切入点之后执行
		c）环绕通知 - 前置/后置增强方法，切入点之前/之后执行
		d）异常通知 - 增强方法出现异常，切入点抛异常则执行
		e）最终通知 - finally，不管有无异常，都会执行

4、切面
	1）把通知应用到切入点的过程



### AOP操作（准备）

1、Spring框架一般基于AspectJ实现AOP操作
	1）什么事AspectJ？
		*AspectJ不是Spring组成部分，是独立的AOP框架，一般把AspectJ和Spring框架一起使用，进行AOP操作

2、基于AspectJ实现AOP操作
	1）基于xml配置文件实现
	2）基于注解方式实现（使用）

3、在项目工程里面引入AOP相关依赖

```xml
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-aop</artifactId>
  <version>5.3.3</version>
</dependency>
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-aspects</artifactId>
  <version>5.3.3</version>
</dependency>
```

4、切入点表达式
	1）切入点表达式作用：知道对哪个类里面的哪个方法进行增强
	2）语法结构：execution([权限修饰符] [返回类型] [类全路径].[方法名称] [参数列表])
		举例1：对com.atguigu.dao.**BookDao类**的**add()方法**进行增强

```plain/text
execution(* com.atguigu.dao.BookDao.add(..))
				权限修饰符：*号表示public或者private方法
				返回类型：省略
				类全路径：com.atguigu.dao.BookDao
				方法名称：.add(..)
				参数列表：.add(..)方法里面的两个点
```

​		举例2：对com.atguigu.dao.**BookDao类**的**所有的方法**进行增强

```plain/text
execution(* com.atguigu.dao.BookDao.add(..))
				权限修饰符：*号表示public或者private方法
				返回类型：省略
				类全路径：com.atguigu.dao.BookDao
				方法名称：.*(..)，*表示所有方法
				参数列表：.*(..)方法里面的两个点
```

​		举例3：对com.atguigu.dao包里的**所有类**，**所有方法**进行增强

```plain/text
execution(* com.atguigu.dao.*.*(..))
				权限修饰符：*号表示public或者private方法
				返回类型：省略
				类全路径：com.atguigu.dao.* -- *号表示所有类
				方法名称：.*(..)，*表示所有方法
				参数列表：.*(..)方法里面的两个点
```



### AOP操作（AspectJ注解）

1、创建类，在类里面定义方法

```java
//需要被增强的类
@Component
public class User {
    public void add() {
        System.out.println("User.add()...");
    }
}
```

2、创建增强类
	1）在增强类里面，创建方法，让不同方法代表不同通知类型

```java
//增强的类
@Component
@Aspect // 生成代理对象
public class UserProxy {

    //前置通知
    @Before(value = "execution(* com.atguigu.spring5.aop.annotation.User.add(..))")
    public void before() {
        System.out.println("UserProxy.before()...");
    }
}
```

3、进行通知的配置
	1）在spring配置文件中引入context开启注解扫描，引入aop

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd
                           http://www.springframework.org/schema/aop https://www.springframework.org/schema/aop/spring-aop.xsd">


    <!--开启组件扫面-->
    <context:component-scan base-package="com.atguigu.spring5.aop.annotation"/>
  
    <!--开启Aspect生成代理对象-->
    <aop:aspectj-autoproxy/>

</beans>
```

​	2）使用注解创建User和UserProxy对象 - 如上加**@Component**
​	3）在**增强类上**面添加注解**@Aspect** - 如上加**@Aspect**
​	4）在spring配置文件中**开启Aspect生成代理对象** - 如上xml的 **aop:aspectj-autoproxy**

4、配置不同类型的通知
	1）在增强类的里面，在作为通知方法上面添加通知类型注解，使用切入点表达式配置 - 如上**@Before(value = "execution(* com.atguigu.spring5.aop.annotation.User.add(..))")**

```java
//增强的类
@Component
@Aspect // 生成代理对象
public class UserProxy {

    //环绕通知 - 之前之后都执行
    @Around(value = "execution(* com.atguigu.spring5.aop.annotation.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("UserProxy.around()...环绕之前");

        //被增强的方法
        proceedingJoinPoint.proceed();  // 这里会捕获异常，如果此处被@AfterThrowing拦住，则不执行该环绕通知方法后的所有代码

        System.out.println("UserProxy.around()...环绕之后");
    }

    //前置通知
    @Before(value = "execution(* com.atguigu.spring5.aop.annotation.User.add(..))")
    public void before() {
        System.out.println("UserProxy.before()...前置通知");
    }

    //后置通知（最终通知）
    @After(value = "execution(* com.atguigu.spring5.aop.annotation.User.add(..))")
    public void after() {
        System.out.println("UserProxy.after()...后置通知");
    }

    //后置返回通知（返回结果执行）
    @AfterReturning(value = "execution(* com.atguigu.spring5.aop.annotation.User.add(..))")
    public void afterReturning() {
        System.out.println("UserProxy.afterReturning()...后置返回通知（返回结果执行）");
    }

    @AfterThrowing(value = "execution(* com.atguigu.spring5.aop.annotation.User.add(..))")
    public void afterThrowing() {
        System.out.println("UserProxy.afterThrowing()...");
    }
}
```

​		Output:

```plain/text
UserProxy.around()...环绕之前
UserProxy.before()...前置通知
User.add()...
UserProxy.afterReturning()...后置返回通知（返回结果执行）
UserProxy.after()...后置通知（最终通知）
UserProxy.around()...环绕之后
```


​	2）测试**抛出异常情况下**的输出：

```java
//需要被增强的类
@Component
public class User {
    public void add() {
        int i = 10/0; // 这里用于测试抛出异常情况
        System.out.println("User.add()...");
    }
}
```

​		Output:

```plain/text
UserProxy.around()...环绕之前
UserProxy.before()...前置通知
UserProxy.afterThrowing()...异常通知
UserProxy.after()...后置通知（最终通知）

java.lang.ArithmeticException: / by zero
```

5、相同的切入点抽取使用@Pointcut

```java
// 相同的切入点抽取
@Pointcut(value = "execution(* com.atguigu.spring5.aop.annotation.User.add(..))")
public void pointcutAddMethod() {
}

//环绕通知 - 之前之后都执行
@Around(value = "pointcutAddMethod()")
public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
  System.out.println("UserProxy.around()...环绕之前");

  //被增强的方法
  proceedingJoinPoint.proceed();  // 这里会捕获异常，如果此处被@AfterThrowing拦住，则不执行该环绕通知方法后的所有代码

  System.out.println("UserProxy.around()...环绕之后");
}

//前置通知
@Before(value = "pointcutAddMethod()")
public void before() {
  System.out.println("UserProxy.before()...前置通知");
}
```

6、有多个增强类对同一方法进行增强，设置增强类优先级别
	1）在增强类上添加注解@Order(数字类型值)，数字类型值越小优先级越高

```java
@Component
@Aspect // 生成代理对象
@Order(1) // 在增强类上添加注解@Order(数字类型值)，数字类型值越小优先级越高
public class UserProxy {
  
@Component
@Aspect // 生成代理对象
@Order(2) // 在增强类上添加注解@Order(数字类型值)，数字类型值越小优先级越高
public class UserProxy2 {
  
@Component
@Aspect // 生成代理对象
@Order(3) // 在增强类上添加注解@Order(数字类型值)，数字类型值越小优先级越高
public class UserProxy3 {
```

​	Output:

```plain/text
UserProxy.around()...环绕之前
UserProxy.before()...前置通知
UserProxy2.around()...环绕之前 -- @Order(2)
UserProxy2.before()...前置通知 -- @Order(2)
UserProxy3.around()...环绕之前 -- @Order(3)
UserProxy3.before()...前置通知 -- @Order(3)
User.add()...
UserProxy3.afterReturning()...后置返回通知（返回结果执行） -- @Order(3)
UserProxy3.after()...后置通知（最终通知） -- @Order(3)
UserProxy3.around()...环绕之后 -- @Order(3)
UserProxy2.afterReturning()...后置返回通知（返回结果执行） -- @Order(2)
UserProxy2.after()...后置通知（最终通知） -- @Order(2)
UserProxy2.around()...环绕之后 -- @Order(2)
UserProxy.afterReturning()...后置返回通知（返回结果执行）
UserProxy.after()...后置通知（最终通知）
UserProxy.around()...环绕之后
```



