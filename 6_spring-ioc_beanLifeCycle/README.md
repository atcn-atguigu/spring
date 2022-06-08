### IOC操作Bean管理（xml）- Bean生命周期

1、生命周期 - 从对象创建到对象销毁的过程

2、bean生命周期
	1）通过无参数构造器创建bean实例
	2）为bean的属性设置和对其它bean的引用（调用set方法）
	3）调用bean的初始化方法
	4）bean可以使用（对象获取到了）
	5）当容器关闭的时候，调用bean的销毁的方法（需要进行配置销毁的方法）

3、另外两步：bean的后置处理器	
	1）通过无参数构造器创建bean实例
	2）为bean的属性设置和对其它bean的引用（调用set方法）
	**把bean实例传递给bean后置处理器的方法 - postProcessBeforeInitialization()**
	3） 调用bean的初始化方法
	**把bean实例传递给bean后置处理器的方法 - postProcessAfterInitialization()**
	4）bean可以使用（对象获取到了）
	5）当容器关闭的时候，调用bean的销毁的方法（需要进行配置销毁的方法）