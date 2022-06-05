### IOC操作Bean管理（xml）- Bean Autowired 自动装配

1、什么是手动装配？
	*之前的装配方式都是通过value或ref来手动指定property的属性值
	*一般常规非自动装配写法如下：

```xml
<bean id="dept" class="com.atguigu.spring5.dependencyInjection.autowired.Department"/>
<bean id="emp" class="com.atguigu.spring5.dependencyInjection.autowired.Employee">
  <property name="department" ref="dept"></property>
</bean>
```



2、什么是自动装配？
	*不需要写property name，以及value或ref来对属性的值指定
	*根据指定装配规则（属性名称或者属性类型），spring自动将匹配的属性值进行注入
	1）根据属性名称进行自动装配 - autowire="byName"

```xml
<bean id="dept" class="com.atguigu.spring5.dependencyInjection.autowired.Department"/>
<bean id="emp" class="com.atguigu.spring5.dependencyInjection.autowired.Employee" autowire="byName"/>
```

​	2）根据属性类型进行自动装配 - autowire="byType"

```xml
<bean id="dept" class="com.atguigu.spring5.dependencyInjection.autowired.Department"/>
<bean id="emp" class="com.atguigu.spring5.dependencyInjection.autowired.Employee" autowire="byType"/>
```

​	注意点：autowire="byType"为默认自动装配方式，如果依赖的属性类型实例有多个，则抛异常：UnsatisfiedDependencyException，expected single matching bean but found 2: dept,dept2

```xml
<!--如下多个byType的自动装配会报错-->
<bean id="dept" class="com.atguigu.spring5.dependencyInjection.autowired.Department"/>
<bean id="dept2" class="com.atguigu.spring5.dependencyInjection.autowired.Department"/>
<bean id="emp" class="com.atguigu.spring5.dependencyInjection.autowired.Employee" autowire="byType"/>
```



