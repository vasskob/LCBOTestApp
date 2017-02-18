package com.obezhenar.lcbotestapp.storage.greendao.specification;

import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.domain.entiry.StoreDao;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

public class StoreFilterAndPagesGreenDaoSpecification implements GreenDaoSpecification<Store> {
    private StoreFilterCriteria criteria;
    private StoreDao storeDao;

    public StoreFilterAndPagesGreenDaoSpecification(StoreFilterCriteria criteria, StoreDao storeDao) {
        this.criteria = criteria;
        this.storeDao = storeDao;
    }

    @Override
    public Query<Store> prepareQuery() {
        QueryBuilder<Store> queryBuilder = storeDao.queryBuilder();
        if (criteria.getHasVintagesCorner() != null) {
            queryBuilder.where(StoreDao.Properties.HasVintagesCorner.eq(true));
        }
        if (criteria.getHasParking() != null) {
            queryBuilder.where(StoreDao.Properties.HasParking.eq(true));
        }
        if (criteria.getHasBeerColdRoom() != null) {
            queryBuilder.where(StoreDao.Properties.HasBeerColdRoom.eq(true));
        }
        if (criteria.getHasBilingualServices() != null) {
            queryBuilder.where(StoreDao.Properties.HasBilingualServices.eq(true));
        }
        if (criteria.getHasTastingBar() != null) {
            queryBuilder.where(StoreDao.Properties.HasTastingBar.eq(true));
        }
        if (criteria.getHasWheelChairAccessibility() != null) {
            queryBuilder.where(StoreDao.Properties.HasWheelchairAccessability.eq(true));
        }
        queryBuilder.offset((int) criteria.getFrom()).limit((int) criteria.getTo());
        return queryBuilder.build();
    }
}
