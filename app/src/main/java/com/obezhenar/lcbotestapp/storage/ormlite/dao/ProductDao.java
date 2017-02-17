package com.obezhenar.lcbotestapp.storage.ormlite.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.obezhenar.lcbotestapp.domain.entiry.Product;

import java.sql.SQLException;

public class ProductDao extends BaseDaoImpl<Product, Long> {
    public ProductDao(ConnectionSource connectionSource, Class<Product> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }
}
