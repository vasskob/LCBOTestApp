package com.obezhenar.lcbotestapp.storage.ormlite.specifications;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.storage.base.OrmLiteSpecification;
import com.obezhenar.lcbotestapp.storage.ormlite.OrmliteOpenHelper;
import com.obezhenar.lcbotestapp.storage.ormlite.dao.StoreDao;

import java.sql.SQLException;

public class OrmLiteStorePagintaionSpecification implements OrmLiteSpecification<Store> {
    private Long from;
    private Long to;
    private StoreDao storeDao;

    public OrmLiteStorePagintaionSpecification(Long from, Long to, StoreDao storeDao) {
        this.from = from;
        this.to = to;
        this.storeDao = storeDao;
    }

    @Override
    public PreparedQuery<Store> prepareQuery() throws SQLException {
        QueryBuilder<Store, Long> queryBuilder = storeDao.queryBuilder();
        queryBuilder.offset(from).limit(to);
        return queryBuilder.prepare();
    }
}
