package com.atguigu.spring5.dependencyInjection.annotations.service;

import org.springframework.stereotype.Component;

@Component // 写法1，不加括号内容，默认值类名首字母小写
//@Component(value="userService") // 写法2，等同于<bean id="userService class=".."/>
public class UserService {

    public void add() {
        System.out.println("service add.....");
    }
}
