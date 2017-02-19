package com.obezhenar.lcbotestapp.storage.greendao.specification_factory;

import com.obezhenar.lcbotestapp.domain.entiry.ProductDao;
import com.obezhenar.lcbotestapp.storage.base.ProductSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.base.Specification;
import com.obezhenar.lcbotestapp.storage.greendao.specifications.product.ProductByIdGreenDaoSpecification;
import com.obezhenar.lcbotestapp.storage.greendao.specifications.product.ProtuctByCategoryGreenDaoSpecification;

public class ProductGreenDaoSpecificationFactory implements ProductSpecificationFactory {
    private ProductDao productDao;

    public ProductGreenDaoSpecificationFactory(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Specification creteProductByIdSpecification(long productId, int from, int to) {
        return new ProductByIdGreenDaoSpecification(productDao, productId, from, to);
    }

    @Override
    public Specification createProductsByQuerySpecification(String query, int from, int to) {
        return new ProtuctByCategoryGreenDaoSpecification(query, from, to, productDao);
    }
}
