package com.atguigu.spring5.dependencyInjection.annotations.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ValueNormalDataInjectionService {

    @Value(value = "abc")
    private String str;

    public void valueTest() {
        System.out.println("使用@Value注入的值为：" + str);
    }
}
