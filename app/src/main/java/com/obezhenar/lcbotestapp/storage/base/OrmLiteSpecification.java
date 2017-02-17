package com.obezhenar.lcbotestapp.storage.base;

import com.j256.ormlite.stmt.PreparedQuery;

import java.sql.SQLException;

public interface OrmLiteSpecification<T> extends Specification {
    PreparedQuery<T> prepareQuery() throws SQLException;
}
