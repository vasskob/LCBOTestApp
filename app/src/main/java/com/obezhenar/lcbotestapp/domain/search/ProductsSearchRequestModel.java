package com.obezhenar.lcbotestapp.domain.search;

public class ProductsSearchRequestModel {
    private String query = "";
    private boolean isSeasonal;
    private boolean isKosher;
    private boolean hasLimitedOffer;
    private int page;

    public ProductsSearchRequestModel() {
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public boolean isSeasonal() {
        return isSeasonal;
    }

    public void setSeasonal(boolean seasonal) {
        isSeasonal = seasonal;
    }

    public boolean isKosher() {
        return isKosher;
    }

    public void setKosher(boolean kosher) {
        isKosher = kosher;
    }

    public boolean isHasLimitedOffer() {
        return hasLimitedOffer;
    }

    public void setHasLimitedOffer(boolean hasLimitedOffer) {
        this.hasLimitedOffer = hasLimitedOffer;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
