package com.atguigu.spring5.dependencyInjection;

public class BookConstructorInjection {

    private String bookName;

    // 2 - 有参数构造注入
    public BookConstructorInjection(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "BookConstructorInjection{" +
                "bookName='" + bookName + '\'' +
                '}';
    }
}
