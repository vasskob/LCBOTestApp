package com.obezhenar.lcbotestapp.screens.product_details.presenter;

import com.obezhenar.lcbotestapp.screens.product_details.view.ProductDetailsView;

public interface ProductDetailsPresenter {
    void loadProductDetails(long productId);
    void attach(ProductDetailsView view);
}
