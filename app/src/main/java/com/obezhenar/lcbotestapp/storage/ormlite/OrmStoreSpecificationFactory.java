package com.obezhenar.lcbotestapp.storage.ormlite;

import com.obezhenar.lcbotestapp.storage.base.Specification;
import com.obezhenar.lcbotestapp.storage.base.StoreSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.ormlite.dao.StoreDao;
import com.obezhenar.lcbotestapp.storage.ormlite.specifications.OrmLiteStorePagintaionSpecification;
import com.obezhenar.lcbotestapp.storage.ormlite.specifications.StoreByIdOrmLiteSpecification;
import com.obezhenar.lcbotestapp.storage.ormlite.specifications.StoreFilterCriteria;

public class OrmStoreSpecificationFactory implements StoreSpecificationFactory {
    private StoreDao storeDao;

    public OrmStoreSpecificationFactory(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    @Override
    public Specification createPaginationSpecification(StoreFilterCriteria criteria) {
        return new OrmLiteStorePagintaionSpecification(criteria, storeDao);
    }

    @Override
    public Specification createStoreByIdSpecification (long storeId) {
        return new StoreByIdOrmLiteSpecification(storeId, storeDao);
    }
}
