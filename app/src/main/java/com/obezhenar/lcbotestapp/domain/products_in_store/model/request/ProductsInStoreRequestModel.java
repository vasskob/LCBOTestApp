package com.obezhenar.lcbotestapp.domain.products_in_store.model.request;

public class ProductsInStoreRequestModel {
    private int page;
    private long storeId;
    private String category;

    public ProductsInStoreRequestModel(int page, long storeId, String category) {
        this.page = page;
        this.storeId = storeId;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }
}
