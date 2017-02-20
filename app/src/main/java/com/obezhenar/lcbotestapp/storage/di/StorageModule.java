package com.obezhenar.lcbotestapp.storage.di;

import android.content.Context;

import com.obezhenar.lcbotestapp.domain.entiry.DaoMaster;
import com.obezhenar.lcbotestapp.domain.entiry.DaoSession;
import com.obezhenar.lcbotestapp.domain.entiry.Inventory;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.storage.base.InventorySpecificationFactory;
import com.obezhenar.lcbotestapp.storage.base.ProductSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.base.Repository;
import com.obezhenar.lcbotestapp.storage.base.StoreSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.greendao.GreenDaoRepository;
import com.obezhenar.lcbotestapp.storage.greendao.specification_factory.StoreGreenDaoSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.greendao.specification_factory.InventoryGreenDaoSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.greendao.specification_factory.ProductGreenDaoSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.preferennces.LcboSharedPreferencesStorage;

import org.greenrobot.greendao.database.Database;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class StorageModule {
    private Context context;
    private DaoSession daoSession;
    private LcboSharedPreferencesStorage preferencesStorage;

    public StorageModule(Context context) {
        this.context = context;
        preferencesStorage = new LcboSharedPreferencesStorage(context);
        DaoMaster.OpenHelper openHelper = new DaoMaster.DevOpenHelper(context, "lcbo_cache");
        Database database = openHelper.getWritableDb();
        if (System.currentTimeMillis() - preferencesStorage.getDbDropTime() > TimeUnit.HOURS.toMillis(24)) {
            DaoMaster.dropAllTables(database, true);
            openHelper.onCreate(database);
            preferencesStorage.saveDatabaseDropTime(System.currentTimeMillis());
        }
        daoSession = new DaoMaster(database).newSession();
    }


    @Provides
    @Singleton
    public Repository<Store> provideStoreRepository() {
        return new GreenDaoRepository<>(daoSession.getStoreDao());
    }

    @Provides
    @Singleton
    public Repository<Product> provideProductRepository() {
        return new GreenDaoRepository<>(daoSession.getProductDao());
    }

    @Provides
    @Singleton
    public Repository<Inventory> provideInventoryRepository() {
        return new GreenDaoRepository<>(daoSession.getInventoryDao());
    }

    @Provides
    @Singleton
    public StoreSpecificationFactory provideStoreSpecificationFactory() {
        return new StoreGreenDaoSpecificationFactory(daoSession.getStoreDao());
    }

    @Provides
    @Singleton
    public ProductSpecificationFactory prvideProductSpecificationFactory() {
        return new ProductGreenDaoSpecificationFactory(daoSession.getProductDao());
    }

    @Provides
    @Singleton
    public InventorySpecificationFactory provideInventorySpecificationFactory() {
        return new InventoryGreenDaoSpecificationFactory(daoSession.getInventoryDao());
    }
}
