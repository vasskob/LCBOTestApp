package com.obezhenar.lcbotestapp.storage.ormlite;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.storage.base.OrmLiteSpecification;
import com.obezhenar.lcbotestapp.storage.base.Repository;
import com.obezhenar.lcbotestapp.storage.base.Specification;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrmliteRepository<T> implements Repository<T> {
    private BaseDaoImpl dao;

    public OrmliteRepository(BaseDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public void add(T item) {
        try {
            dao.createOrUpdate(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAll(List<T> items) {
        try {
            dao.createOrUpdate(items);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(T item) {
        try {
            dao.update(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(T item) {
        try {
            dao.delete(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> query(Specification specification) {
        if (specification != null)
            try {
                PreparedQuery query = ((OrmLiteSpecification<T>) specification).prepareQuery();
                return dao.query(query);
            } catch (ClassCastException e) {
                throw new RuntimeException("Incorrect query specification type. Please use OrmLiteSpecification with <T> generic type");
            } catch (SQLException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        return queryForAll();
    }

    @Override
    public List<T> queryForAll() {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
