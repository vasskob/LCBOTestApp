package com.obezhenar.lcbotestapp.storage.ormlite.specifications;

import com.j256.ormlite.stmt.PreparedQuery;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.storage.base.OrmLiteSpecification;
import com.obezhenar.lcbotestapp.storage.ormlite.dao.StoreContract;
import com.obezhenar.lcbotestapp.storage.ormlite.dao.StoreDao;

import java.sql.SQLException;

public class StoreByIdOrmLiteSpecification implements OrmLiteSpecification<Store> {
    private long storeId;
    private StoreDao storeDao;

    public StoreByIdOrmLiteSpecification(long storeId, StoreDao storeDao) {
        this.storeId = storeId;
        this.storeDao = storeDao;
    }

    @Override
    public PreparedQuery<Store> prepareQuery() throws SQLException {
        return storeDao.queryBuilder()
                .where()
                .eq(StoreContract.COLUMN_ID, storeId)
                .prepare();
    }
}
