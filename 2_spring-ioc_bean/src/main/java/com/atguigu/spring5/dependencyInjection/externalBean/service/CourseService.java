package com.atguigu.spring5.dependencyInjection.externalBean.service;

import com.atguigu.spring5.dependencyInjection.externalBean.dao.CourseDao;

public class CourseService {

    // 声明外部对象属性CourseDao(接口)，生成setter方法
    private CourseDao courseDao;

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public void add() {
        System.out.println("CourseService.add().....");
        courseDao.update(); // 接口调用实现类（多态）
    }
}
