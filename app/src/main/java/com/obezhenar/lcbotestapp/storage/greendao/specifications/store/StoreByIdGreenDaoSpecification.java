package com.obezhenar.lcbotestapp.storage.greendao.specifications.store;

import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.domain.entiry.StoreDao;
import com.obezhenar.lcbotestapp.storage.greendao.specifications.GreenDaoSpecification;

import org.greenrobot.greendao.query.Query;

public class StoreByIdGreenDaoSpecification implements GreenDaoSpecification<Store> {
    private StoreDao storeDao;
    private long whereId;

    public StoreByIdGreenDaoSpecification(Long whereId, StoreDao storeDao) {
        this.whereId = whereId;
        this.storeDao = storeDao;
    }

    @Override
    public Query<Store> prepareQuery() {
        return storeDao.queryBuilder().where(
                StoreDao.Properties.Id.eq(whereId)).build();
    }
}
