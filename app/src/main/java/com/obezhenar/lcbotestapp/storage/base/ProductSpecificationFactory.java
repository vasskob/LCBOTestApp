package com.obezhenar.lcbotestapp.storage.base;

public interface ProductSpecificationFactory {
    Specification creteProductByIdSpecification(long productId, String category, int from, int to);

    Specification createProductsByQuerySpecification(String query, int from, int to);
}
