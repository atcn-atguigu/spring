### AOP操作（AspectJ配置文件）--了解即可

1、创建两个类：增强类，被增强类，创建方法

```java
//需要被增强的类
public class User {
    public void add() {
        System.out.println("User.add()...");
    }
}

//增强的类
public class UserProxy {
    public void before() {
        System.out.println("UserProxy.before()...前置通知");
    }
}
```



2、在spring配置文件中创建两个类对象

```xml
<!-- 1. 创建两个类的对象 -->
<bean id="user" class="com.atguigu.spring5.aop.xml.User"></bean>
<bean id="userProxy" class="com.atguigu.spring5.aop.xml.UserProxy"></bean>
```



3、在spring配置文件中配置切入点

```xml
<!-- 2. 配置aop增强-->
<aop:config>
  <!--配置切入点-->
  <aop:pointcut id="pointcutAddMethod" expression="execution(* com.atguigu.spring5.aop.xml.User.add(..))"/>

  <!--配置切面: ref引用代理类-->
  <aop:aspect ref="userProxy">
    <!--配置增强作用在具体的方法上，这里是UserProxy类上的before方法作用在切入点add()方法上-->
    <aop:before method="before" pointcut-ref="pointcutAddMethod"/>
  </aop:aspect>
</aop:config>
```

​	Output：

```plain/text
UserProxy.before()...前置通知
User.add()...
```

小结：这里只需要清楚了解配置的方式，实际应用上，多数使用注解而不是这小节的配置文件写法。

