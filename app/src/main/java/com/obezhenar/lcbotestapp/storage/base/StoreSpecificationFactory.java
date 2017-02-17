package com.obezhenar.lcbotestapp.storage.base;

public interface StoreSpecificationFactory {
    /**
     * Query by pages
     * @param fromNumber
     * @param toNumber
     * @return
     */
    Specification CreatePaginationSpecification(long fromNumber, long toNumber);
}
