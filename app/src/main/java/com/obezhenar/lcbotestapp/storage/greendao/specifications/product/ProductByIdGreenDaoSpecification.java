package com.obezhenar.lcbotestapp.storage.greendao.specifications.product;

import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.domain.entiry.ProductDao;
import com.obezhenar.lcbotestapp.storage.greendao.specifications.GreenDaoSpecification;

import org.greenrobot.greendao.query.Query;

public class ProductByIdGreenDaoSpecification implements GreenDaoSpecification<Product> {
    private ProductDao productDao;
    private long productId;
    private String category;
    private int from;
    private int to;

    public ProductByIdGreenDaoSpecification(
            ProductDao productDao,
            long productId,
            String category,
            int from,
            int to) {
        this.category = category;
        this.productDao = productDao;
        this.productId = productId;
        this.from = from;
        this.to = to;
    }

    @Override
    public Query<Product> prepareQuery() {
        return productDao.queryBuilder()
                .where(ProductDao.Properties.Id.eq(productId))
                .where(ProductDao.Properties.PrimaryCategory.like("%" + category + "%"))
                .offset(from)
                .limit(to)
                .build();
    }
}
