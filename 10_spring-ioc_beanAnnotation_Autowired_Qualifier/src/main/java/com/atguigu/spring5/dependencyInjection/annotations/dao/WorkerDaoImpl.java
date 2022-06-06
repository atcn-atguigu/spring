package com.atguigu.spring5.dependencyInjection.annotations.dao;

import org.springframework.stereotype.Repository;

//@Repository // 根据类型注入
@Repository(value = "workerDaoImpl")  // 根据名称注入
public class WorkerDaoImpl implements WorkerDao{

    public void add() {
        System.out.println("WorkerDaoImpl.add() - worker dao add.....");
    }
}
