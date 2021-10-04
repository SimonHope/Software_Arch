package com.solid.book;

import java.util.List;

public class printToScreen{

    Book book;
    public Print(Book book){
        this.book = book;
    }

    public void printToScreen() {
        Book book = this;
        do {
            System.out.println(book.getCurrentPage());
        } while (book.turnToNextPage());
    }
}