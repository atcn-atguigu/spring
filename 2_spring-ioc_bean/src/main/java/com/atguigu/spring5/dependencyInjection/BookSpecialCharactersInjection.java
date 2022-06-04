package com.atguigu.spring5.dependencyInjection;

public class BookSpecialCharactersInjection {

    private String bookName;
    private String address;

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "BookSpectialCharactersInjection{" +
                "bookName='" + bookName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
