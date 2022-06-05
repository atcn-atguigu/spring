package com.atguigu.spring5.dependencyInjection.beanLifeCycle;

public class Orders {

    public Orders() {
        System.out.println("第一步 执行无参数构造创建bean实例");
    }

    private String orderName;

    public void setOrderName(String orderName) {
        this.orderName = orderName;
        System.out.println("第二步 调用set方法设置属性值");
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderName='" + orderName + '\'' +
                '}';
    }

    // 创建执行的初始化方法
    public void myCustomInitMethod() {
        System.out.println("第三步 调用初始化方法");
    }

    // 创建执行的销毁方法
    public void myCustomDestroyMethod() {
        System.out.println("第五步 调用销毁方法");
    }
}
