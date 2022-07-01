package com.atguigu.spring5.webFlux.service.impl;

import com.atguigu.spring5.webFlux.entity.User;
import com.atguigu.spring5.webFlux.service.UserService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

//用户操作接口实现类
@Component
public class UserServiceImpl implements UserService {

    //创建map集合存储数据（这里为了知识点学习方便，不从数据库造数据取出）
    private final Map<Integer, User> users = new HashMap<>();

    public UserServiceImpl() {
        this.users.put(1, new User("Lucy", "female", 20));
        this.users.put(2, new User("Mary", "female", 30));
        this.users.put(3, new User("Jack", "female", 50));
    }

    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(this.users.get(id));
    }

    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.users.values());
    }

    @Override
    public Mono<Void> saveUserInfo(Mono<User> userMono) {
        return userMono.doOnNext(person -> {
            //向map集合里面放值
            int id = users.size() + 1;
            users.put(id, person);
        }).thenEmpty(Mono.empty()); //清空Mono元素终止
    }
}
