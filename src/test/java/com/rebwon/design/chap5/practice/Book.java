package com.rebwon.design.chap5.practice;

import java.time.LocalDate;

public final class Book {

    private final String isbn;
    private final LocalDate publishedDate;
    private final int price;

    public Book(String isbn, LocalDate publishedDate, int price) {
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public int getPrice() {
        return price;
    }
}
