package com.rebwon.stream.fastcampus;

import com.rebwon.stream.fastcampus.model.Price;
import com.rebwon.stream.fastcampus.service.BasicPriceProcessor;
import com.rebwon.stream.fastcampus.service.DiscountPriceProcessor;
import com.rebwon.stream.fastcampus.service.PriceProcessor;
import com.rebwon.stream.fastcampus.service.TaxPriceProcessor;

public final class PriceProcessorTests {

    public static void main(String[] args) {
        Price unprocessedPrice = new Price("Original Price");

        PriceProcessor basicPriceProcessor = new BasicPriceProcessor();
        PriceProcessor discountPriceProcessor = new DiscountPriceProcessor();
        PriceProcessor taxPriceProcessor = new TaxPriceProcessor();

        PriceProcessor decoratedPriceProcessor = basicPriceProcessor
            .andThen(discountPriceProcessor)
            .andThen(taxPriceProcessor);
        Price processedPrice = decoratedPriceProcessor.process(unprocessedPrice);
        System.out.println(processedPrice.getPrice());

        PriceProcessor decoratedPriceProcessor2 = basicPriceProcessor
            .andThen(taxPriceProcessor)
            .andThen(price -> new Price(price.getPrice() + ", then apply another procedure"));
        Price processedPrice2 = decoratedPriceProcessor2.process(unprocessedPrice);
        System.out.println(processedPrice2.getPrice());
    }
}
