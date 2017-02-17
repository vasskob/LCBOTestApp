package com.obezhenar.lcbotestapp.storage.base;

public interface Mapper<FROM, TO> {
    TO map(FROM data);
}
