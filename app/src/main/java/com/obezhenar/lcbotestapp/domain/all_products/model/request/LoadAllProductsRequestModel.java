package com.obezhenar.lcbotestapp.domain.all_products.model.request;

public class LoadAllProductsRequestModel {
    private String query;
    private int page;

    public LoadAllProductsRequestModel(String query, int page) {
        this.query = query;
        this.page = page;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}


