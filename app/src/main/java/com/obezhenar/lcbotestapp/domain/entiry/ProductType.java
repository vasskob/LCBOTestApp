package com.obezhenar.lcbotestapp.domain.entiry;

public enum ProductType {
    BEER,
    WINE,
    SPIRIT;

    @Override
    public String toString() {
        switch (this) {
            case BEER:
                return "Beer";
            case WINE:
                return "Wine";
            case SPIRIT:
                return "Spirit";
        }
        return super.toString();
    }
}
