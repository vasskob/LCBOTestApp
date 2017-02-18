package com.obezhenar.lcbotestapp.screens.products.di;

import com.obezhenar.lcbotestapp.screens.products.view.ProductsFragment;

import dagger.Subcomponent;

@Subcomponent(modules = ProductsModule.class)
@ProductsScope
public interface ProductsComponent {
    void inject(ProductsFragment fragment);
}
