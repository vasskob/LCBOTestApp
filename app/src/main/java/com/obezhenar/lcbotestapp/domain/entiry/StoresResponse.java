package com.obezhenar.lcbotestapp.domain.entiry;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StoresResponse {
    @SerializedName("result")
    private List<Store> stores;

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
}
