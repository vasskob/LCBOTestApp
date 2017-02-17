package com.obezhenar.lcbotestapp.storage.greendao;

import com.obezhenar.lcbotestapp.domain.entiry.StoreDao;
import com.obezhenar.lcbotestapp.storage.base.Repository;
import com.obezhenar.lcbotestapp.storage.base.Specification;
import com.obezhenar.lcbotestapp.storage.greendao.specification.GreenDaoSpecification;

import org.greenrobot.greendao.AbstractDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Green dao repository
 *
 * @param <T> Entity
 * @param <K> Primary key, if it does not exist - use Void
 */
public class GreenDaoRepository<T, K> implements Repository<T> {
    private AbstractDao<T, K> dao;

    public GreenDaoRepository(AbstractDao<T, K> dao) {
        this.dao = dao;
    }

    @Override
    public void add(T item) {
        dao.insertOrReplace(item);
    }

    @Override
    public void addAll(List<T> items) {
        dao.insertOrReplaceInTx(items);
    }

    @Override
    public void update(T item) {
        dao.update(item);
    }

    @Override
    public void remove(T item) {
        dao.delete(item);
    }

    @Override
    public List<T> query(Specification specification) {
        try {
            GreenDaoSpecification<T> daoSpecification = (GreenDaoSpecification<T>) specification;
            return daoSpecification.prepareQuery().list();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> queryForAll() {
        return dao.queryBuilder().list();
    }
}
