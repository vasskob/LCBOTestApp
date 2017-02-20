package com.obezhenar.lcbotestapp.storage.greendao.specification_factory;

import com.obezhenar.lcbotestapp.domain.entiry.ProductDao;
import com.obezhenar.lcbotestapp.domain.search.ProductsSearchRequestModel;
import com.obezhenar.lcbotestapp.storage.base.ProductSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.base.Specification;
import com.obezhenar.lcbotestapp.storage.greendao.specifications.product.ProductByIdGreenDaoSpecification;
import com.obezhenar.lcbotestapp.storage.greendao.specifications.product.ProtuctByCategoryGreenDaoSpecification;
import com.obezhenar.lcbotestapp.storage.greendao.specifications.product.SearchProductsGreenDaoSpecification;

public class ProductGreenDaoSpecificationFactory implements ProductSpecificationFactory {
    private ProductDao productDao;

    public ProductGreenDaoSpecificationFactory(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Specification creteProductByIdSpecification(long productId, String category, int from, int to) {
        return new ProductByIdGreenDaoSpecification(productDao, productId, category, from, to);
    }

    @Override
    public Specification createProductsByQuerySpecification(String query, int from, int to) {
        return new ProtuctByCategoryGreenDaoSpecification(query, from, to, productDao);
    }

    @Override
    public Specification createSearchBuProductsSpecification(ProductsSearchRequestModel model) {
        return new SearchProductsGreenDaoSpecification(productDao, model);
    }
}
