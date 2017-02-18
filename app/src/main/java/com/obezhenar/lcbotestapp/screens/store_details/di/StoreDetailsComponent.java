package com.obezhenar.lcbotestapp.screens.store_details.di;

import com.obezhenar.lcbotestapp.screens.store_details.view.StoreDetailsFragment;

import dagger.Component;
import dagger.Subcomponent;

@Subcomponent(modules = StoreDetailsModule.class)
@StoreDetailsScope
public interface StoreDetailsComponent {
    void inject(StoreDetailsFragment fragment);
}
