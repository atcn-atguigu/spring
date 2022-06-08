package com.atguigu.spring5.dependencyInjection.beanLifeCycle;

public class Orders3 {

    public Orders3() {
        System.out.println("Orders3： 第一步 执行无参数构造创建bean实例");
    }

    private String orderName;

    public void setOrderName(String orderName) {
        this.orderName = orderName;
        System.out.println("Orders3： 第二步 调用set方法设置属性值");
    }

    @Override
    public String toString() {
        return "Orders3{" +
                "orderName='" + orderName + '\'' +
                '}';
    }

    // 创建执行的初始化方法
    public void myCustomInitMethod3() {
        System.out.println("Orders3： 第三步 调用初始化方法");
    }

    // 创建执行的销毁方法
    public void myCustomDestroyMethod3() {
        System.out.println("Orders3： 第五步 调用销毁方法");
    }
}
