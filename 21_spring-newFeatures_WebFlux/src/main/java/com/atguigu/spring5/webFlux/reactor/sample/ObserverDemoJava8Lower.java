package com.atguigu.spring5.webFlux.reactor.sample;

import java.util.Observable;

public class ObserverDemoJava8Lower extends Observable {

    public static void main(String[] args) {
        ObserverDemoJava8Lower observer = new ObserverDemoJava8Lower();

        //添加观察者1
        observer.addObserver((o, arg) -> {
            System.out.println("观察者1 - 收到变化通知");
        });
        //添加观察者2 -- 注意有多个观察者，则会倒序遍历通知
        observer.addObserver((o, arg) -> {
            System.out.println("观察者2 - 收到变化通知");
        });

        //数据变化
        observer.setChanged();
        //通知
        observer.notifyObservers();
    }
}
