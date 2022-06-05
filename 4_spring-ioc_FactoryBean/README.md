### IOC操作Bean管理（xml: FactoryBean）

1、Spring有两种类型bean，一种普通bean，另外一种工厂bean（FactoryBean）

2、普通bean：在配置文件中定义bean类型就是返回类型

3、工厂bean（FactoryBean）：在配置文件中定义bean类型，与返回类型不一致
    1）第一步：创建类，让这个类作为工厂bean，实现接口FactoryBean
	2）第二步：实现接口里面的方法，在实现的方法中定义返回的bean类型
