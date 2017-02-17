package com.obezhenar.lcbotestapp.storage.greendao.specification;

import com.obezhenar.lcbotestapp.storage.base.Specification;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.Query;

public interface GreenDaoSpecification<T> extends Specification {
    Query<T> prepareQuery();
}
