package com.atguigu.spring5.transanctionalXml.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 多钱的方法: Mary收到Lucy转过来的100
    public void addMoney() {
        String sql = "UPDATE t_accounts SET money=money+? where username=?";
        jdbcTemplate.update(sql, 100, "Mary");
    }


    // 少钱的方法: Lucy转账100给Mary
    public void reduceMoney() {
        String sql = "UPDATE t_accounts SET money=money-? where username=?";
        jdbcTemplate.update(sql, 100, "Lucy");
    }
}
