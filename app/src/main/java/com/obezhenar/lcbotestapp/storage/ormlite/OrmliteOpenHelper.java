package com.obezhenar.lcbotestapp.storage.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.storage.ormlite.dao.ProductDao;
import com.obezhenar.lcbotestapp.storage.ormlite.dao.StoreDao;

import java.sql.SQLException;

public class OrmliteOpenHelper extends OrmLiteSqliteOpenHelper {
    private static final int DB_VERSION = 2;
    private static final String DB_NAME = "lcbo_databese.db";

    private StoreDao storeDao;
    private ProductDao productDao;

    public OrmliteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Store.class);
            TableUtils.createTable(connectionSource, Product.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Store.class, true);
            TableUtils.dropTable(connectionSource, Product.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public StoreDao getStoreDao() throws SQLException {
        if (storeDao == null)
            storeDao = new StoreDao(getConnectionSource(), Store.class);
        return storeDao;
    }

    public ProductDao getProductDao() throws SQLException {
        if (productDao == null)
            productDao = new ProductDao(getConnectionSource(), Product.class);
        return productDao;
    }

    @Override
    public void close() {
        super.close();
        productDao = null;
        storeDao = null;
    }
}
