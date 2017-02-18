package com.obezhenar.lcbotestapp.storage.greendao.specification_factory;

import com.obezhenar.lcbotestapp.domain.entiry.ProductDao;
import com.obezhenar.lcbotestapp.storage.base.ProductSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.base.Specification;
import com.obezhenar.lcbotestapp.storage.greendao.specifications.product.ProductByIdGreenDaoSpecification;

public class ProductGreenDaoSpecificationFactory implements ProductSpecificationFactory {
    private ProductDao productDao;

    public ProductGreenDaoSpecificationFactory(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Specification creteProductByIdSpecification(long productId) {
        return new ProductByIdGreenDaoSpecification(productDao, productId);
    }
}
