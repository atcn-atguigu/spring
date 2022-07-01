package com.atguigu.spring5.webFlux.reactor.sample;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestWebFluxReactor {

    public static void main(String[] args) {
        /**
         * 使用subscribe订阅才会触发数据流，不订阅什么都不会发生
         */
        //just方法直接声明式
        Flux.just(1,2,3,4).subscribe(System.out::println); // just方法可传可变参数
        Mono.just(1).subscribe(System.out::println);

        //其他方法 - 数组声明方式
        Integer[] array = {5,6,7};
        Flux.fromArray(array).subscribe(System.out::println);

        //其他方法 - 列表声明方式
        List<Integer> list = Arrays.asList(array);
        Flux.fromIterable(list).subscribe(System.out::println);

        //其他方法 - 流声明方式
        Stream<Integer> stream = list.stream();
        Flux.fromStream(stream).subscribe(System.out::println);


    }
}
