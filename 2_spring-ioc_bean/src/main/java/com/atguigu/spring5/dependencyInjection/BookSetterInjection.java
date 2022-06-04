package com.atguigu.spring5.dependencyInjection;

public class BookSetterInjection {

    private String bookName;

    // 1 - Set 方法注入
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "BookSetterInjection{" +
                "bookName='" + bookName + '\'' +
                '}';
    }
}
