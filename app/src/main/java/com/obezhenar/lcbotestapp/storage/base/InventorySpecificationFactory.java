package com.obezhenar.lcbotestapp.storage.base;

public interface InventorySpecificationFactory {
    public Specification createInventoryByStoreIdSpecification(long storedId);
}
