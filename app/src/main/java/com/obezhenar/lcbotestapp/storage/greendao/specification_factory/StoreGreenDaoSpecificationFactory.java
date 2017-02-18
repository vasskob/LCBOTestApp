package com.obezhenar.lcbotestapp.storage.greendao.specification_factory;

import com.obezhenar.lcbotestapp.domain.entiry.StoreDao;
import com.obezhenar.lcbotestapp.storage.base.Specification;
import com.obezhenar.lcbotestapp.storage.base.StoreSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.greendao.specifications.store.StoreByIdGreenDaoSpecification;
import com.obezhenar.lcbotestapp.storage.greendao.specifications.store.StoreFilterAndPagesGreenDaoSpecification;
import com.obezhenar.lcbotestapp.storage.greendao.specifications.store.StoreFilterCriteria;

public class StoreGreenDaoSpecificationFactory implements StoreSpecificationFactory {
    public StoreDao storeDao;

    public StoreGreenDaoSpecificationFactory(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    @Override
    public Specification createPaginationSpecification(StoreFilterCriteria criteria) {
        return new StoreFilterAndPagesGreenDaoSpecification(criteria, storeDao);
    }

    @Override
    public Specification createStoreByIdSpecification(long storeId) {
        return new StoreByIdGreenDaoSpecification(storeId, storeDao);
    }
}
