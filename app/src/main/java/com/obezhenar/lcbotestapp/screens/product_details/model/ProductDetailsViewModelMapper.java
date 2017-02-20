package com.obezhenar.lcbotestapp.screens.product_details.model;

import com.obezhenar.lcbotestapp.common.util.Mapper;
import com.obezhenar.lcbotestapp.domain.entiry.Product;

public class ProductDetailsViewModelMapper implements Mapper<Product, ProductDetailsViewModel> {
    @Override
    public ProductDetailsViewModel map(Product data) {
        return new ProductDetailsViewModel(
                data.getId(),
                data.getName(),
                String.valueOf((float) data.getPriceInCents() / 100f),
                String.valueOf((float) data.getAlcoholContent() / 100f),
                data.getTags(),
                data.getImageUrl()
        );
    }
}
