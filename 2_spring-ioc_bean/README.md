### IOC操作：Bean管理

1、什么是Bean管理？Bean管理的两个操作是什么？
	1）Spring创建对象
	2）Spring注入属性

2、Bean管理操作的两种方式
	1）基于xml配置文件方式实现
	2）基于注解方式实现



### IOC操作Bean管理（基于xml方式）

1、基于xml方式创建对象
	1）在Spring配置文件中使用bean标签，标签里面添加对应属性，就可以实现对象创建
	2）在bean标签有很多属性，介绍常用属性：
		*id属性：唯一标识
		*class属性：类全路径（包类路径）
	3）创建对象时候，默认也是执行**无参数构造方法**完成对象创建

```xml
<!--配置User对象创建-->
<bean id="user" class="com.atguigu.spring5.User"></bean>
```

2、基于xml方式注入属性
	1）DI：依赖注入，就是注入属性
		第一种注入方式：使用setter方法注入
		第二种注入方式：使用有参数构造方法注入



### IOC操作Bean管理（xml注入其它类型属性）

1、注入属性：字面量null
	1）null值
	2）属性包含特殊符号

```xml
<!--null值-->
<property name="address" value="">
	<null/>
</property>

<property name="address">
  <value><![CDATA[特殊字符内容]]></value>
</property>
```

2、注入属性：外部bean - 使用ref关键字
	1）创建两个类：service类和dao类
	2）在service调用dao里面的方法
	3）在spring配置文件中进行配置

```xml
<!--service和dao对象创建-->
    <bean id="courseService" class="com.atguigu.spring5.dependencyInjection.externalBean.service.CourseService">
        <!--注入CourseDao对象
            name：类里面的属性名称
            ref: 外部bean的id
        -->
        <property name="courseDao" ref="courseDaoImpl"/>
    </bean>

    <!--这里dao的class使用的是实现类，告诉spring反射对应实现类从而能创建实现类对象-->
    <bean id="courseDaoImpl" class="com.atguigu.spring5.dependencyInjection.externalBean.dao.CourseDaoImpl"></bean>
```

3、注入属性：内部bean（一般）
	1）一对多关系：部门和员工
		一个部门有多个员工，一个员工属于一个部门，部门是一，员工是多。
	2）在实体类之间表示一对多的关系：员工表示所属部门（使用对象类型属性表示）
	3）在spring配置文件中进行配置

```xml
<!--Employee和Department对象创建-->
<bean id="employee" class="com.atguigu.spring5.dependencyInjection.internalBean.entity.Employee">
  <property name="employeeName" value="张三"/>
  <property name="gender" value="男"/>
  <!--设置内部bean属性-->
  <property name="department">
    <bean id="department" class="com.atguigu.spring5.dependencyInjection.internalBean.entity.Department">
      <property name="departmentName" value="IT部门"/>
    </bean>
  </property>
</bean>
```

4、注入属性：内部bean（使用ref关键字：级联赋值）

```xml
<!--级联赋值: 第一种写法-->
<bean id="employee" class="com.atguigu.spring5.dependencyInjection.internalBean.entity.Employee">
    <property name="employeeName" value="李四"/>
    <property name="gender" value="男"/>
    <!--级联赋值写法1，使用ref-->
    <property name="department" ref="department"/>
</bean>
<bean id="department" class="com.atguigu.spring5.dependencyInjection.internalBean.entity.Department">
    <property name="departmentName" value="级联1：软件部门"/>
</bean>
```

```xml
<!--级联赋值: 第二种写法-->
<bean id="employee" class="com.atguigu.spring5.dependencyInjection.internalBean.entity.Employee">
    <property name="employeeName" value="李四"/>
    <property name="gender" value="男"/>
    <!--级联赋值写法2，使用.链式写法
        注意，类需要生成getter方法才能使用
    -->
    <property name="department" ref="department"></property>
    <property name="department.departmentName" value="级联2：技术部"></property>
</bean>
<bean id="department" class="com.atguigu.spring5.dependencyInjection.internalBean.entity.Department">
    <property name="departmentName" value="软件部门"></property>
</bean>
```

