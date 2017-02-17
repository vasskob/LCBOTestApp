package com.obezhenar.lcbotestapp.domain.entiry;

import com.google.gson.annotations.SerializedName;

public class SingleStoreApiResponse {
    @SerializedName("result")
    private Store store;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
