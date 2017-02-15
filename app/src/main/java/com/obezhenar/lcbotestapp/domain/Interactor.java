package com.obezhenar.lcbotestapp.domain;

/**
 * Represents peace of business logic
 *
 * @param <IN>  Input data
 * @param <OUT> Output data
 */
public interface Interactor<IN, OUT> {
    OUT invoke(IN data);
}
