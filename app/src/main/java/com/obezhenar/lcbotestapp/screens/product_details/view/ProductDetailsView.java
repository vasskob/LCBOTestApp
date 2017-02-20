package com.obezhenar.lcbotestapp.screens.product_details.view;

import android.view.View;

import com.bumptech.glide.Glide;
import com.obezhenar.lcbotestapp.screens.product_details.model.ProductDetailsViewModel;

public interface ProductDetailsView {
    void displayProductDetails(ProductDetailsViewModel details);

    void displayError(String message);

    void setShowProgress(boolean showProgress);
}
