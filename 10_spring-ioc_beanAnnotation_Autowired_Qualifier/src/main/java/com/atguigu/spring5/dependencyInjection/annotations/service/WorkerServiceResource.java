package com.atguigu.spring5.dependencyInjection.annotations.service;

import com.atguigu.spring5.dependencyInjection.annotations.dao.WorkerDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WorkerServiceResource {

//    @Resource // 根据类型注入
    @Resource(name="workerDaoImpl") // 根据名称注入
    private WorkerDao workerDao;

    public void add() {
        System.out.println("WorkerServiceResource.add() - worker service add.....");
        workerDao.add();
    }
}
