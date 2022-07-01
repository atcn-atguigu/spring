package com.atguigu.spring5.webFlux.controller;

import com.atguigu.spring5.webFlux.entity.User;
import com.atguigu.spring5.webFlux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//创建controller
@RestController
public class UserController {

    //注入service
    @Autowired
    private UserService userService;

    //根据id查询用户
    @GetMapping("/user/{id}")
    public Mono<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    //查询所有用户
    @GetMapping("/user")
    public Flux<User> getAllUser() {
        return userService.getAllUser();
    }

    //添加用户
    @PostMapping("/saveUser")
    public Mono<Void> saveUserInfo(@RequestBody User user) {
        Mono<User> userNew = Mono.just(user);
        return userService.saveUserInfo(userNew);
    }
}
