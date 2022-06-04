package com.atguigu.spring5.dependencyInjection;

public class BookNullValueInjection {

    private String bookName;
    private String address;

    // 1 - Set 方法注入
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "BookNullValue{" +
                "bookName='" + bookName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
