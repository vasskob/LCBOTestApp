package com.obezhenar.lcbotestapp.app.di;

import com.obezhenar.lcbotestapp.api.di.ApiModule;
import com.obezhenar.lcbotestapp.domain.di.DomainModule;
import com.obezhenar.lcbotestapp.screens.store_details.di.StoreDetailsComponent;
import com.obezhenar.lcbotestapp.screens.store_details.di.StoreDetailsModule;
import com.obezhenar.lcbotestapp.screens.stores.di.StoresComponent;
import com.obezhenar.lcbotestapp.screens.stores.di.StoresModule;
import com.obezhenar.lcbotestapp.storage.di.StorageModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {
        AppModule.class,
        StorageModule.class,
        ApiModule.class,
        DomainModule.class
})
@Singleton
public interface AppComponent {
    StoresComponent plusStoresComponent(StoresModule module);

    StoreDetailsComponent plusStoreDetailsComponent(StoreDetailsModule module);
}
