package com.atguigu.spring5.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//增强的类
@Component
@Aspect // 生成代理对象
public class UserProxy {

    //环绕通知 - 之前之后都执行
    @Around(value = "execution(* com.atguigu.spring5.aop.annotation.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("UserProxy.around()...环绕之前");

        //被增强的方法
        proceedingJoinPoint.proceed();  // 这里会捕获异常，如果此处被@AfterThrowing拦住，则不执行该环绕通知方法后的所有代码

        System.out.println("UserProxy.around()...环绕之后");
    }

    //前置通知
    @Before(value = "execution(* com.atguigu.spring5.aop.annotation.User.add(..))")
    public void before() {
        System.out.println("UserProxy.before()...前置通知");
    }

    //后置通知（最终通知）
    @After(value = "execution(* com.atguigu.spring5.aop.annotation.User.add(..))")
    public void after() {
        System.out.println("UserProxy.after()...后置通知（最终通知）");
    }

    //后置返回通知（返回结果执行）
    @AfterReturning(value = "execution(* com.atguigu.spring5.aop.annotation.User.add(..))")
    public void afterReturning() {
        System.out.println("UserProxy.afterReturning()...后置返回通知（返回结果执行）");
    }

    //异常通知
    @AfterThrowing(value = "execution(* com.atguigu.spring5.aop.annotation.User.add(..))")
    public void afterThrowing() {
        System.out.println("UserProxy.afterThrowing()...异常通知");
    }
}
