package com.obezhenar.lcbotestapp.storage.base;

import java.util.List;

/**
 * Simple Repository pattern implementation
 *
 * @param <T> Data type
 */
public interface Repository<T> {
    void add(T item);

    void addAll(List<T> items);

    void update(T item);

    void remove(T item);

    List<T> query(Specification specification);

    List<T> queryForAll();
}
