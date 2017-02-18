package com.obezhenar.lcbotestapp.screens.eventbus;

public class ShowProductDetailsEvent {
    private long productId;

    public ShowProductDetailsEvent(long productId) {
        this.productId = productId;
    }

    public long getProductId() {
        return productId;
    }
}
