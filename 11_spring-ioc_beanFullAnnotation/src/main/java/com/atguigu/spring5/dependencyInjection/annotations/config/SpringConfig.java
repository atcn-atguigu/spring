package com.atguigu.spring5.dependencyInjection.annotations.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 作为配置类，替代xml配置文件
/**
 * 开启组件扫面:
 *  方式1：如果扫描多个包， 多个包使用逗号隔开
 *  方式2：扫描包上层目录
 */
//@ComponentScan(basePackages = {"com.atguigu.spring5.dependencyInjection.annotations.dao, com.atguigu.spring5.dependencyInjection.annotations.service"})
@ComponentScan(basePackages = {"com.atguigu.spring5"})
public class SpringConfig {
}
