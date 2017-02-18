package com.obezhenar.lcbotestapp.screens.products.view;

import com.obezhenar.lcbotestapp.screens.products.model.ProductViewModel;

import java.util.List;

public interface ProductsView {
    void displayProducts(List<ProductViewModel> products);

    void displayNoProducts();

    void setShowProgress(boolean showProgress);
}
