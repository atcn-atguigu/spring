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
        /**
         * Proxy.newProxyInstance()方法参数说明：
         * 第一个参数：当前类自身的类加载器；
         * 第二个参数：需要被代理的类所实现的（一个或多个）接口
         * 第三个参数：InvocationHandler接口实现类，写增强的地方，这里需要传入被代理的实现类对象"userDaoImpl"
         */
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDaoImpl));

        System.out.println("\n---------- 开始测试第一个方法：有返回值 ----------");
        int result = dao.add(1, 2);
        System.out.println("返回值为：" + result);

        System.out.println("\n---------- 开始测试第二个方法：没有返回值 ----------");
        dao.sendMsg("你好啊");
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

        // 被增强的方法执行
        Object res = method.invoke(object, args);

        // 方法之后
        System.out.println("UserDaoProxy.invoke() - 方法之后执行了，方法名为："  + method.getName() + "：传递的参数..." + Arrays.toString(args) + "当前对象：" + object);

        return res;
    }
}