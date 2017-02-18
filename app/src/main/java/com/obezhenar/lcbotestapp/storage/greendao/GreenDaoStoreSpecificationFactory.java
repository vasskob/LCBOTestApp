package com.obezhenar.lcbotestapp.storage.greendao;

import com.obezhenar.lcbotestapp.domain.entiry.StoreDao;
import com.obezhenar.lcbotestapp.storage.base.Specification;
import com.obezhenar.lcbotestapp.storage.base.StoreSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.greendao.specification.StoreByIdGreenDaoSpecification;
import com.obezhenar.lcbotestapp.storage.greendao.specification.StoreFilterAndPagesGreenDaoSpecification;
import com.obezhenar.lcbotestapp.storage.greendao.specification.StoreFilterCriteria;

public class GreenDaoStoreSpecificationFactory implements StoreSpecificationFactory {
    public StoreDao storeDao;

    public GreenDaoStoreSpecificationFactory(StoreDao storeDao) {
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
