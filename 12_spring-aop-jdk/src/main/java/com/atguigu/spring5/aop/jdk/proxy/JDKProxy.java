package com.atguigu.spring5.aop.jdk.proxy;

import com.atguigu.spring5.aop.jdk.dao.UserDao;
import com.atguigu.spring5.aop.jdk.dao.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {
    public static void main(String[] args) {

        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDaoImpl = new UserDaoImpl();

        // 创建接口实现类的代理对象


        // 写法1， InvocationHandler使用匿名内部类
        /*
        Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        */

        // 写法2：不使用InvocationHandler匿名内部类；而是使用一个实现InvocationHandler的代理类实例
        // 接口 = 实现类
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDaoImpl));
        int result = dao.add(1, 2);
        System.out.println(result);
    }
}


// 创建代理对象代码
class UserDaoProxy implements InvocationHandler {

    // 1、创建谁的代理对象，把谁传递过来；这里为了通用一些，写成Object
    private Object object;

    // 有参数构造传递
    public UserDaoProxy(Object object) {
        this.object = object;
    }

    // 增强的逻辑，需要传入被代理的接口
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 方法之前
        System.out.println("UserDaoProxy.invoke() - 方法之前执行了，方法名为：" + method.getName() + "：传递的参数..." + Arrays.toString(args) + "当前对象：" + object);

        // 被赠钱的方法执行
        Object res = method.invoke(object, args);

        // 方法之后
        System.out.println("UserDaoProxy.invoke() - 方法之后执行了，方法名为："  + method.getName() + "：传递的参数..." + Arrays.toString(args) + "当前对象：" + object);

        return res;
    }
}