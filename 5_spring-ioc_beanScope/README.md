### IOC操作Bean管理（xml）- Bean Scope作用域

1、Spring里面，默认情况下，bean是单例对象

2、如何设置单实例还是多实例
	1）scope属性值
		第一个值（默认值）：singleton，表示是单实例对象
		第二个值：prototype，表示是多实例对象

3、singleton和prototype区别
	第一个区别：singleton表示单实例，prototype表示多实例
	第二个区别：设置scope值是singleton的时候，加载spring配置文件时候（new ClassPathXmlApplicationContext()）就会创建单实例对象；设置scope值是prototype的时候，不是在加载spring配置文件时候创建对象，而是在调用getBean方法时候才创建多实例对象

4、其它scope属性值
	request - 现已少用，web相关，表示请求一次
	session - 现已少用，web相关，表示创建对象放到session

