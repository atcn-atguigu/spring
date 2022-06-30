### 事务操作（XML声明式事务管理）

1、在spring配置文件中进行配置
	1）第一步 配置**事务管理器**
	2）第二步 配置**通知**
	3）第三步 配置**切入点**和**切面**

```xml
<!--1 创建事务管理器-->
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
  <!--注入数据源-->
  <property name="dataSource" ref="dataSource"/>
</bean>

<!--2 配置通知-->
<tx:advice id="txadvice">
  <tx:attributes>
    <!--Option1：指定具体某个方法添加事务-->
    <tx:method name="moveMoney" propagation="REQUIRED" isolation="REPEATABLE_READ" timeout="-1"/>
    <!--Option2: 正则匹配方法添加事务-->
    <!--            <tx:method name="move*"/>-->
  </tx:attributes>
</tx:advice>

<!--3 配置切入点和切面-->
<aop:config>
  <!--配置切入点-->
  <aop:pointcut id="pt" expression="execution(* com.atguigu.spring5.transanctionalXml.service.UserService.*(..))"/>
  <!--配置切面-->
  <aop:advisor advice-ref="txadvice" pointcut-ref="pt"/>
</aop:config>
```

