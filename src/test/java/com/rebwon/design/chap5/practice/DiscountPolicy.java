package com.rebwon.design.chap5.practice;

import java.time.LocalDate;
import java.time.Period;

public interface DiscountPolicy {

    boolean isSatisfiedBy(Member member, Book book, int count);

    int calculateDiscountPrice(Member member, Book book, int count);

    class AccumulateAmountDiscountPolicy implements DiscountPolicy {

        @Override
        public boolean isSatisfiedBy(Member member, Book book, int count) {
            return member.getAccumulateAmount() >= 10000;
        }

        @Override
        public int calculateDiscountPrice(Member member, Book book, int count) {
            return (int) (book.getPrice() * 0.1) * count;
        }
    }

    class PeriodDiscountPolicy implements DiscountPolicy {

        @Override
        public boolean isSatisfiedBy(Member member, Book book, int count) {
            Period period = Period.between(book.getPublishedDate(), LocalDate.now());
            return period.getYears() >= 10;
        }

        @Override
        public int calculateDiscountPrice(Member member, Book book, int count) {
            return (int) (book.getPrice() * 0.2) * count;
        }
    }

    class CountDiscountPolicy implements DiscountPolicy {

        @Override
        public boolean isSatisfiedBy(Member member, Book book, int count) {
            return count >= 5;
        }

        @Override
        public int calculateDiscountPrice(Member member, Book book, int count) {
            return (int) (book.getPrice() * 0.05) * count;
        }
    }
}
