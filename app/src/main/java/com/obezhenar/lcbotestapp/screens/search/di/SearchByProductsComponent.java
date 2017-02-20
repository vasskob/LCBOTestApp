package com.obezhenar.lcbotestapp.screens.search.di;

import com.obezhenar.lcbotestapp.screens.search.view.SearchByProductsFragment;

import dagger.Subcomponent;

@SearchByProductsScope
@Subcomponent(modules = SearchByProductsModule.class)
public interface SearchByProductsComponent {
    void inject(SearchByProductsFragment fragment);
}
