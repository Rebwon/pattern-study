package com.rebwon.stream.fastcampus.service;

import com.rebwon.stream.fastcampus.model.Price;

public class DiscountPriceProcessor implements PriceProcessor {

    @Override
    public Price process(Price price) {
        return new Price(price.getPrice() + ", then applied discount");
    }
}
