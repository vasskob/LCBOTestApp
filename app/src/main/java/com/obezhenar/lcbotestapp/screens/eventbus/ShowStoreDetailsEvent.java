package com.obezhenar.lcbotestapp.screens.eventbus;

public class ShowStoreDetailsEvent {
    private long storeId;

    public ShowStoreDetailsEvent(long storeId) {
        this.storeId = storeId;
    }

    public long getStoreId() {
        return storeId;
    }
}
