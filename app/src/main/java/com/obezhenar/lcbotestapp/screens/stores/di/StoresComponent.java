package com.obezhenar.lcbotestapp.screens.stores.di;

import com.obezhenar.lcbotestapp.screens.stores.view.StoresFragment;

import dagger.Subcomponent;

@Subcomponent(modules = StoresModule.class)
@StoresScope
public interface StoresComponent {
    void inject(StoresFragment fragment);
}
