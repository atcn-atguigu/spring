package com.atguigu.spring5.dependencyInjection.beanLifeCycle;

public class Orders2 {

    public Orders2() {
        System.out.println("Orders2： 第一步 执行无参数构造创建bean实例");
    }

    private String orderName;

    public void setOrderName(String orderName) {
        this.orderName = orderName;
        System.out.println("Orders2： 第二步 调用set方法设置属性值");
    }

    @Override
    public String toString() {
        return "Orders2{" +
                "orderName='" + orderName + '\'' +
                '}';
    }
}
