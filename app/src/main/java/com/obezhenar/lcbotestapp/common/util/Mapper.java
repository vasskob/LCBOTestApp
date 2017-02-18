package com.obezhenar.lcbotestapp.common.util;

public interface Mapper<FROM, TO> {
    TO map(FROM data);
}
