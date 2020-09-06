package com.example.design.ObserverPatternPriceChange;

public class Test {
    public static void main(String[] args) {
        ProductObservable product = new ProductObservable();
        PriceObserver priceObserver = new PriceObserver();
        product.addObserver(priceObserver);
        product.setPrice(1.01f);
        product.setPrice(1.02f);

    }
}
