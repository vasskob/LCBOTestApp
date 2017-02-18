package com.obezhenar.lcbotestapp.storage.greendao.specification_factory;

import com.obezhenar.lcbotestapp.domain.entiry.InventoryDao;
import com.obezhenar.lcbotestapp.storage.base.InventorySpecificationFactory;
import com.obezhenar.lcbotestapp.storage.base.Specification;
import com.obezhenar.lcbotestapp.storage.greendao.specifications.inventory.InventoryByStoreIdGreenDaoSpecification;

public class InventoryGreenDaoSpecificationFactory implements InventorySpecificationFactory {
    private InventoryDao inventoryDao;

    public InventoryGreenDaoSpecificationFactory(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    @Override
    public Specification createInventoryByStoreIdSpecification(long storedId) {
        return new InventoryByStoreIdGreenDaoSpecification(storedId, inventoryDao);
    }
}
