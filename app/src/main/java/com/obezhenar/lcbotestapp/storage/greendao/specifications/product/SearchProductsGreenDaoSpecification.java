package com.obezhenar.lcbotestapp.storage.greendao.specifications.product;

import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.domain.entiry.ProductDao;
import com.obezhenar.lcbotestapp.domain.search.ProductsSearchRequestModel;
import com.obezhenar.lcbotestapp.storage.greendao.specifications.GreenDaoSpecification;

import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class SearchProductsGreenDaoSpecification implements GreenDaoSpecification<Product> {
    private ProductDao productDao;
    private ProductsSearchRequestModel requestModel;

    public SearchProductsGreenDaoSpecification(
            ProductDao productDao,
            ProductsSearchRequestModel requestModel) {
        this.productDao = productDao;
        this.requestModel = requestModel;
    }

    @Override
    public Query<Product> prepareQuery() {
        QueryBuilder<Product> queryBuilder = productDao.queryBuilder();
        queryBuilder.where(ProductDao.Properties.Tags.like("%" + requestModel.getQuery() + "%"));
        if (requestModel.isSeasonal())
            queryBuilder.where(ProductDao.Properties.IsSeasonal.eq(true));
        if (requestModel.isKosher())
            queryBuilder.where(ProductDao.Properties.IsKosher.eq(true));
        if (requestModel.isHasLimitedOffer())
            queryBuilder.where(ProductDao.Properties.HasLimitedTimeOffer.eq(true));
        queryBuilder.offset((requestModel.getPage() - 1) * 20);
        queryBuilder.limit(((requestModel.getPage() - 1) * 20) + 20);
        return queryBuilder.build();
    }
}
