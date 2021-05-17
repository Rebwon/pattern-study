package com.rebwon.design.chap5.practice;

import static org.assertj.core.api.Assertions.assertThat;

import com.rebwon.design.chap5.practice.DiscountPolicy.AccumulateAmountDiscountPolicy;
import com.rebwon.design.chap5.practice.DiscountPolicy.CountDiscountPolicy;
import com.rebwon.design.chap5.practice.DiscountPolicy.PeriodDiscountPolicy;
import java.time.LocalDate;
import java.util.Set;
import org.junit.jupiter.api.Test;

public final class BookRentalAppTests {

    @Test
    void name() {
        Book book1 = new Book("isbn", LocalDate.now(), 15000);
        Book book2 = new Book("isbn", LocalDate.of(2010, 1, 2), 13000);

        Member member = new Member("Kim", 14000);

        RentalItem item1 = new RentalItem(book1, 6,
            Set.of(new CountDiscountPolicy(), new PeriodDiscountPolicy()));
        RentalItem item2 = new RentalItem(book2, 4,
            Set.of(new CountDiscountPolicy(), new PeriodDiscountPolicy(), new AccumulateAmountDiscountPolicy()));

        Rental rental = new Rental(member, Set.of(item1, item2));

        rental.process();

        assertThat(rental.getTotalAmount()).isEqualTo(9700);
    }
}
