package com.rebwon.stream.fastcampus.service;

import com.rebwon.stream.fastcampus.model.Price;

public class BasicPriceProcessor implements PriceProcessor {

    @Override
    public Price process(Price price) {
        return price;
    }
}
