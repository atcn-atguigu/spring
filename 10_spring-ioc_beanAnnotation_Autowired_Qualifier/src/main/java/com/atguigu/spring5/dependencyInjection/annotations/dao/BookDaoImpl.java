package com.atguigu.spring5.dependencyInjection.annotations.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    public void add() {
        System.out.println("BookDaoImpl.add() - book dao add...");
    }
}
