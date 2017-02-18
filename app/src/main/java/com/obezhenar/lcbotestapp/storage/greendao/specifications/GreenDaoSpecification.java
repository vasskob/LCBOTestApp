package com.obezhenar.lcbotestapp.storage.greendao.specifications;

import com.obezhenar.lcbotestapp.storage.base.Specification;

import org.greenrobot.greendao.query.Query;

public interface GreenDaoSpecification<T> extends Specification {
    Query<T> prepareQuery();
}
