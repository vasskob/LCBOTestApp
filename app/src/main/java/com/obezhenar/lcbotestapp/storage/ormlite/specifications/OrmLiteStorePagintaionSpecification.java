package com.obezhenar.lcbotestapp.storage.ormlite.specifications;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.storage.base.OrmLiteSpecification;
import com.obezhenar.lcbotestapp.storage.ormlite.dao.StoreContract;
import com.obezhenar.lcbotestapp.storage.ormlite.dao.StoreDao;

import java.sql.SQLException;

public class OrmLiteStorePagintaionSpecification implements OrmLiteSpecification<Store> {
    StoreFilterCriteria criteria;
    private StoreDao storeDao;

    public OrmLiteStorePagintaionSpecification(StoreFilterCriteria criteria, StoreDao storeDao) {
        this.criteria = criteria;
        this.storeDao = storeDao;
    }

    @Override
    public PreparedQuery<Store> prepareQuery() throws SQLException {
        QueryBuilder<Store, Long> queryBuilder = storeDao.queryBuilder();
        int conditionCount = 0;
        Where<Store, Long> where = queryBuilder.where();
        if (criteria.getHasVintagesCorner() != null) {
            where.eq(StoreContract.COLUMN_HAS_BEERCOLDROOM, true);
            conditionCount++;
        }
        if (criteria.getHasParking() != null) {
            where.eq(StoreContract.COLUMN_HAS_PARKING, true);
            conditionCount++;
        }
        if (criteria.getHasBeerColdRoom() != null) {
            where.eq(StoreContract.COLUMN_HAS_BEERCOLDROOM, true);
            conditionCount++;
        }
        if (criteria.getHasBilingualServices() != null) {
            where.eq(StoreContract.COLUMN_HAS_BILINGUAL_SERVICES, true);
            conditionCount++;
        }
        if (criteria.getHasTastingBar() != null) {
            where.eq(StoreContract.COLUMN_HAS_TASTIN_GBAR, true);
            conditionCount++;
        }
        if (criteria.getHasWheelChairAccessibility() != null) {
            where.eq(StoreContract.COLUMN_HAS_WHEELCHAIR_ACCESSABILITY, true);
            conditionCount++;
        }
        if (conditionCount > 0)
            where.and(conditionCount);
        else
            queryBuilder.reset();
        queryBuilder.offset(criteria.getFrom()).limit(criteria.getTo());
        return queryBuilder.prepare();
    }
}
