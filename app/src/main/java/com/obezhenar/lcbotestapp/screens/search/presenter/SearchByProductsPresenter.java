package com.obezhenar.lcbotestapp.screens.search.presenter;

import android.widget.TextView;

import com.obezhenar.lcbotestapp.screens.search.view.SearchByProductsView;

public interface SearchByProductsPresenter {
    void attach(SearchByProductsView view);

    void onSearchQuery(String query);

    void onFilterSettingsChanged(
            boolean isSeasonal,
            boolean isKosher,
            boolean hasLimitedTimeOffer
    );

    void loadMore();
}
