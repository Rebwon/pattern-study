package com.rebwon.design.chap5.practice;

import java.util.Set;

public final class Rental {

    private Member member;
    private Set<RentalItem> books;
    private int totalAmount;

    public Rental(Member member, Set<RentalItem> books) {
        this.member = member;
        this.books = books;
    }

    public void process() {
        totalAmount = books.stream()
            .mapToInt(item -> item.calculateDiscountPrice(member))
            .sum();
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
