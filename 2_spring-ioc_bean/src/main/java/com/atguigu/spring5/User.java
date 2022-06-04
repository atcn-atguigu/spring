package com.atguigu.spring5;

public class User {

//    private String userName;
//
//    public User(String userName) {  // 显式定义有参构造的话，则默认spring通过工厂模式+反射使用无参构造创建bean对象是会失败的
//        this.userName = userName;
//    }

    public void add() {
        System.out.println("User.add().....");
    }
}
