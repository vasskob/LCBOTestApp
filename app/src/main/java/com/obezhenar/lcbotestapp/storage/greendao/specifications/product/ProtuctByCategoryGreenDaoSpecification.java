package com.obezhenar.lcbotestapp.storage.greendao.specifications.product;

import com.obezhenar.lcbotestapp.domain.entiry.ProductDao;
import com.obezhenar.lcbotestapp.storage.greendao.specifications.GreenDaoSpecification;

import org.greenrobot.greendao.query.Query;

public class ProtuctByCategoryGreenDaoSpecification implements GreenDaoSpecification {
    private String category;
    private int from;
    private int to;
    private ProductDao productDao;

    public ProtuctByCategoryGreenDaoSpecification(String category, int from, int to, ProductDao productDao) {
        this.category = category;
        this.from = from;
        this.to = to;
        this.productDao = productDao;
    }

    @Override
    public Query prepareQuery() {
        return productDao.queryBuilder()
                .where(ProductDao.Properties.PrimaryCategory.like("%" + category + "%"))
                .offset(from)
                .limit(to)
                .build();
    }
}
