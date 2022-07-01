package com.atguigu.spring5.webFlux.reactor.sample;

public class FlowDemo4Java9Higher {

    // 该类需要在Java9以上运行
//    public static void main(String[] args) {
//        Flow.Publisher<String> publisher = subscriber -> {
//            subscriber.onNext("1"); // 1
//            subscriber.onNext("2");
//            subscriber.onError(new RuntimeException("出错")); // 2
////            subscriber.onComplete();
//        };
//
//        publisher.subscribe((new Flow.Subscriber<>() {
//
//            @Override
//            public void onSubscribe(Flow.Subscription subscription) {
//                subscription.cancel();
//            }
//
//            @Override
//            public void onNext(String item) {
//                System.out.println(item);
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                System.out.println("出错了");
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("publish complete");
//            }
//        }));
//    }
}
