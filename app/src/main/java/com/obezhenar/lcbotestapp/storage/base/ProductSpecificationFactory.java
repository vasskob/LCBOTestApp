package com.obezhenar.lcbotestapp.storage.base;

import com.obezhenar.lcbotestapp.domain.search.ProductsSearchRequestModel;

public interface ProductSpecificationFactory {
    Specification creteProductByIdSpecification(long productId, String category, int from, int to);

    Specification createProductsByQuerySpecification(String query, int from, int to);

    Specification createSearchBuProductsSpecification(ProductsSearchRequestModel model);
}
