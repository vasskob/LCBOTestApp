package com.obezhenar.lcbotestapp.screens.product_details.di;

import com.obezhenar.lcbotestapp.screens.product_details.view.ProductDetailsDialog;

import dagger.Subcomponent;

@Subcomponent(modules = ProductDetailsModule.class)
@ProductDetailsScope
public interface ProductDetailsComponent {
    void inject(ProductDetailsDialog detailsDialog);
}
