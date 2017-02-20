package com.obezhenar.lcbotestapp.screens.search.view;

import android.view.View;

import com.obezhenar.lcbotestapp.R;
import com.obezhenar.lcbotestapp.screens.products.model.ProductViewModel;

import java.util.List;

public interface SearchByProductsView {
    void displaySearchResults(List<ProductViewModel> results);

    void showNoResults();

    void setShowProgress(boolean showProgress);

    void displayMore(List<ProductViewModel> results);
}
