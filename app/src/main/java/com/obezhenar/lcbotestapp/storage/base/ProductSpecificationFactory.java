package com.obezhenar.lcbotestapp.storage.base;

public interface ProductSpecificationFactory {
    Specification creteProductByIdSpecification(long productId, int from, int to);

    Specification createProductsByQuerySpecification(String query, int from, int to);
}
