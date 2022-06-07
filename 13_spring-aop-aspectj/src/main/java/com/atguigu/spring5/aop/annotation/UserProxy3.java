package com.atguigu.spring5.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强的类
@Component
@Aspect // 生成代理对象
@Order(3) // 在增强类上添加注解@Order(数字类型值)，数字类型值越小优先级越高
public class UserProxy3 {

    // 相同的切入点抽取
    @Pointcut(value = "execution(* com.atguigu.spring5.aop.annotation.User.add(..))")
    public void pointcutAddMethod() {
    }

    //环绕通知 - 之前之后都执行
    @Around(value = "pointcutAddMethod()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("UserProxy3.around()...环绕之前 -- @Order(3)");

        //被增强的方法
        proceedingJoinPoint.proceed();  // 这里会捕获异常，如果此处被@AfterThrowing拦住，则不执行该环绕通知方法后的所有代码

        System.out.println("UserProxy3.around()...环绕之后 -- @Order(3)");
    }

    //前置通知
    @Before(value = "pointcutAddMethod()")
    public void before() {
        System.out.println("UserProxy3.before()...前置通知 -- @Order(3)");
    }

    //后置通知（最终通知）
    @After(value = "pointcutAddMethod()")
    public void after() {
        System.out.println("UserProxy3.after()...后置通知（最终通知） -- @Order(3)");
    }

    //后置返回通知（返回结果执行）
    @AfterReturning(value = "pointcutAddMethod()")
    public void afterReturning() {
        System.out.println("UserProxy3.afterReturning()...后置返回通知（返回结果执行） -- @Order(3)");
    }

    //异常通知
    @AfterThrowing(value = "pointcutAddMethod()")
    public void afterThrowing() {
        System.out.println("UserProxy3.afterThrowing()...异常通知 -- @Order(3)");
    }
}
