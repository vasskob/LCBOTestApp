package com.obezhenar.lcbotestapp.storage.di;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.storage.base.Repository;
import com.obezhenar.lcbotestapp.storage.base.StoreSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.ormlite.OrmStoreSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.ormlite.OrmliteOpenHelper;
import com.obezhenar.lcbotestapp.storage.ormlite.OrmliteRepository;

import java.sql.SQLException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class StorageModule {
    private Context context;
    private OrmliteOpenHelper databaseOpenHelper;

    public StorageModule(Context context) {
        this.context = context;
        databaseOpenHelper = OpenHelperManager.getHelper(context, OrmliteOpenHelper.class);
    }


    @Provides
    @Singleton
    public Repository<Store> provideStoreRepository() {
        try {
            return new OrmliteRepository<Store>(databaseOpenHelper.getStoreDao());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not access to database");
        }
    }

    @Provides
    @Singleton
    public Repository<Product> provideProductRepository() {
        try {
            return new OrmliteRepository<Product>(databaseOpenHelper.getProductDao());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not access to database");
        }
    }

    @Provides
    @Singleton
    public StoreSpecificationFactory provideStoreSpecificationFactory() {
        try {
            return new OrmStoreSpecificationFactory(databaseOpenHelper.getStoreDao());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not access to database");
        }
    }
}
