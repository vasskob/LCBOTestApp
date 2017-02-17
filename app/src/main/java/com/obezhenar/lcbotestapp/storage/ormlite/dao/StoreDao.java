package com.obezhenar.lcbotestapp.storage.ormlite.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.obezhenar.lcbotestapp.domain.entiry.Store;

import java.sql.SQLException;

public class StoreDao extends BaseDaoImpl<Store, Long> {
    public StoreDao(ConnectionSource connectionSource, Class<Store> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }
}
