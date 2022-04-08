package com.rebwon.refactoring.splitphase;

record Product(double basePrice, double discountThreshold, double discountRate) {

}

record ShippingMethod(double discountThreshold, double discountFee, double feePerCase) {

}

record PricingData(double basePrice, double discount, int quantity) {

}

public final class Order {

    double priceOrder(Product product, int quantity, ShippingMethod shippingMethod) {
        PricingData pricingData = calculatePricingData(product, quantity);
        return applyShippingCost(shippingMethod, pricingData);
    }

    private PricingData calculatePricingData(Product product, int quantity) {
        double basePrice = product.basePrice() * quantity;
        double discount = Math.max(quantity - product.discountThreshold(), 0)
            * product.basePrice() * product.discountRate();
        return new PricingData(basePrice, discount, quantity);
    }

    private double applyShippingCost(ShippingMethod shippingMethod, PricingData pricingData) {
        double shippingPerCase = (pricingData.basePrice() > shippingMethod.discountThreshold())
            ? shippingMethod.discountFee() : shippingMethod.feePerCase();
        double shippingCost = pricingData.quantity() * shippingPerCase;
        return pricingData.basePrice() - pricingData.discount() + shippingCost;
    }
}