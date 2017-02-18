package com.obezhenar.lcbotestapp.screens.products.model;

import com.obezhenar.lcbotestapp.common.util.Mapper;
import com.obezhenar.lcbotestapp.domain.entiry.Product;

public class PrductToViewModelMapper implements Mapper<Product, ProductViewModel> {
    @Override
    public ProductViewModel map(Product data) {
        return new ProductViewModel(
                data.getId(),
                data.getName(),
                data.getTags(),
                data.getImageThumbUrl()
        );
    }
}
