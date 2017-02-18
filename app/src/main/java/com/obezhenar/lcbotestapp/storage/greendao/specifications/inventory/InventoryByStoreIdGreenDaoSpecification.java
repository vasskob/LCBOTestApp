package com.obezhenar.lcbotestapp.storage.greendao.specifications.inventory;

import com.obezhenar.lcbotestapp.domain.entiry.Inventory;
import com.obezhenar.lcbotestapp.domain.entiry.InventoryDao;
import com.obezhenar.lcbotestapp.storage.greendao.specifications.GreenDaoSpecification;

import org.greenrobot.greendao.query.Query;

public class InventoryByStoreIdGreenDaoSpecification implements GreenDaoSpecification<Inventory> {
    private long storeId;
    private InventoryDao inventoryDao;

    public InventoryByStoreIdGreenDaoSpecification(long storeId, InventoryDao inventoryDao) {
        this.storeId = storeId;
        this.inventoryDao = inventoryDao;
    }

    @Override
    public Query<Inventory> prepareQuery() {
        return inventoryDao.queryBuilder().where(InventoryDao.Properties.StoreId.eq(storeId)).build();
    }
}
