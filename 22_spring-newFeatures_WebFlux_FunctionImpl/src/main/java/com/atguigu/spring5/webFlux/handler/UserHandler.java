package com.atguigu.spring5.webFlux.handler;

import com.atguigu.spring5.webFlux.entity.User;
import com.atguigu.spring5.webFlux.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class UserHandler {

    private UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    //根据id查询用户
    public Mono<ServerResponse> getUserById(ServerRequest serverRequest) {
        //获取请求发过来的id值
        int id = Integer.parseInt(serverRequest.pathVariable("id"));

        //空值处理
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        //调用service方法得到数据
        Mono<User> userMono = this.userService.getUserById(id);

        //把Mono<User> userMono进行转换返回，这里使用Reactor操作符flatMap对返回值进行处理
        return userMono
                .flatMap(person -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromObject(person)))
                .switchIfEmpty(notFound);
    }

    //查询所有用户
    public Mono<ServerResponse> getAllUser(ServerRequest serverRequest) {
        //调用service方法得到数据
        Flux<User> allUser = this.userService.getAllUser();

        //把Flux<User> allUser进行转换返回
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(allUser, User.class);
    }

    //添加用户
    public Mono<ServerResponse> saveUserInfo(ServerRequest serverRequest) {
        //获取请求发过来的User
        Mono<User> userMono = serverRequest.bodyToMono(User.class);

        //调用service方法得到数据，然后将该变化通过ServerResponse的build方法订阅
        return ServerResponse.ok().build(this.userService.saveUserInfo(userMono));
    }
}
