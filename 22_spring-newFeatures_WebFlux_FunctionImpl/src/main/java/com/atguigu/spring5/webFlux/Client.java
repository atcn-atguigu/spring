package com.atguigu.spring5.webFlux;

import com.atguigu.spring5.webFlux.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class Client {

    public static void main(String[] args) {
        //调用服务器地址，端口根据动态生成端口填入
        WebClient webClient = WebClient.create("http://localhost:64209");

        //根据id查询用户
        String id = "1";
        User user = webClient.get().uri("/user/{id}", id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(User.class)
                .block();

        System.out.println("=========================== 根据id查询用户 ===========================");
        System.out.println(user.toString());
        System.out.println("=========================== 根据id查询用户 ===========================\n");

        //查询所有用户
        Flux<User> userFlux = webClient.get().uri("/user").accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(User.class);
        System.out.println("=========================== 查询所有用户 ===========================");
        userFlux.map(person -> person.getName())
                .buffer().doOnNext(System.out::println).blockFirst();
        System.out.println("=========================== 查询所有用户 ===========================\n");
    }
}
