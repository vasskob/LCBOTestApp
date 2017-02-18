package com.obezhenar.lcbotestapp.screens.eventbus;

public class ShowStoreProductsEvent {
    private long storeId;

    public ShowStoreProductsEvent(long storeId) {
        this.storeId = storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public long getStoreId() {
        return storeId;
    }
}
