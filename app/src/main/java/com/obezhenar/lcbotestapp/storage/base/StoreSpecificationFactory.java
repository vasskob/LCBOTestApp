package com.obezhenar.lcbotestapp.storage.base;

import com.obezhenar.lcbotestapp.storage.ormlite.specifications.StoreFilterCriteria;

public interface StoreSpecificationFactory {
    /**
     * Query by pages
     *
     * @return
     */
    Specification createPaginationSpecification(StoreFilterCriteria criteria);

    public Specification createStoreByIdSpecification(long storeId);
}
