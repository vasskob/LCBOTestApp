package com.obezhenar.lcbotestapp.storage.greendao.specifications.product;

import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.domain.entiry.ProductDao;
import com.obezhenar.lcbotestapp.storage.greendao.specifications.GreenDaoSpecification;

import org.greenrobot.greendao.query.Query;

public class ProductByIdGreenDaoSpecification implements GreenDaoSpecification<Product> {
    private ProductDao productDao;
    private long productId;

    public ProductByIdGreenDaoSpecification(ProductDao productDao, long productId) {
        this.productDao = productDao;
        this.productId = productId;
    }

    @Override
    public Query<Product> prepareQuery() {
        return productDao.queryBuilder().where(ProductDao.Properties.Id.eq(productId)).build();
    }
}
