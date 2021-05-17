package com.rebwon.design.chap5.practice;

import java.util.Set;

public final class RentalItem {

    private final Book book;
    private final int count;
    private Set<DiscountPolicy> rentalItemDiscountPolicies;

    public RentalItem(Book book, int count, Set<DiscountPolicy> rentalItemDiscountPolicies) {
        this.book = book;
        this.count = count;
        this.rentalItemDiscountPolicies = rentalItemDiscountPolicies;
    }

    public int calculateDiscountPrice(Member member) {
        for(DiscountPolicy discountPolicy : rentalItemDiscountPolicies) {
            if(discountPolicy.isSatisfiedBy(member, book, count)) {
                return discountPolicy.calculateDiscountPrice(member, book, count);
            }
        }
        return book.getPrice() * this.count;
    }
}
