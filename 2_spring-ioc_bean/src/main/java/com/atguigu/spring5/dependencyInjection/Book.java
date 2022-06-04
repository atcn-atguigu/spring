package com.atguigu.spring5.dependencyInjection;

public class Book {

    private String bookName;

    public Book() {
    }
    // 1 - Set 方法注入
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    // 2 - 有参数构造注入
    public Book(String bookName) {
        this.bookName = bookName;
    }

    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setBookName("方法1： 无参数构造，使用setter注入");
        System.out.println(book1.bookName);

        Book book2 = new Book("方法2： 使用有参数构造方式注入");
        System.out.println(book2.bookName);
    }
}
