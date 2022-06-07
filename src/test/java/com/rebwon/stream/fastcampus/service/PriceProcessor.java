package com.rebwon.stream.fastcampus.service;

import com.rebwon.stream.fastcampus.model.Price;

@FunctionalInterface
public interface PriceProcessor {

    Price process(Price price);

    default PriceProcessor andThen(PriceProcessor next) {
        return price -> next.process(process(price));
    }
}

