package com.obezhenar.lcbotestapp.storage.ormlite;

import com.obezhenar.lcbotestapp.storage.base.Specification;
import com.obezhenar.lcbotestapp.storage.base.StoreSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.ormlite.dao.StoreDao;
import com.obezhenar.lcbotestapp.storage.ormlite.specifications.OrmLiteStorePagintaionSpecification;

public class OrmStoreSpecificationFactory implements StoreSpecificationFactory {
    private StoreDao storeDao;

    public OrmStoreSpecificationFactory(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    @Override
    public Specification CreatePaginationSpecification(long fromNumber, long toNumber) {
        return new OrmLiteStorePagintaionSpecification(fromNumber, toNumber, storeDao);
    }
}
