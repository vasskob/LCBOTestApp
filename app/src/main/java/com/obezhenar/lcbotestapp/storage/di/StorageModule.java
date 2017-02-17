package com.obezhenar.lcbotestapp.storage.di;

import android.content.Context;
import com.obezhenar.lcbotestapp.domain.entiry.DaoMaster;
import com.obezhenar.lcbotestapp.domain.entiry.DaoSession;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.storage.base.Repository;
import com.obezhenar.lcbotestapp.storage.base.StoreSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.greendao.GreenDaoRepository;
import com.obezhenar.lcbotestapp.storage.greendao.GreenDaoStoreSpecificationFactory;

import org.greenrobot.greendao.database.Database;

import java.sql.SQLException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class StorageModule {
    private Context context;
    private DaoSession daoSession;

    public StorageModule(Context context) {
        this.context = context;
        DaoMaster.OpenHelper openHelper = new DaoMaster.DevOpenHelper(context, "lcbo_cache");
        Database database = openHelper.getWritableDb();
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
    public StoreSpecificationFactory provideStoreSpecificationFactory() {
        return new GreenDaoStoreSpecificationFactory(daoSession.getStoreDao());
    }
}
