package com.obezhenar.lcbotestapp.app.di;

import android.content.Context;

import com.obezhenar.lcbotestapp.api.ApiModule;
import com.obezhenar.lcbotestapp.domain.di.DomainModule;
import com.obezhenar.lcbotestapp.screens.stores.di.StoresComponent;
import com.obezhenar.lcbotestapp.screens.stores.di.StoresModule;
import com.obezhenar.lcbotestapp.storage.StorageModule;

public class DependencyGraph {
    private Context appContext;
    private AppComponent appComponent;
    private StoresComponent storesComponent;

    public DependencyGraph(Context appContext) {
        this.appContext = appContext;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(appContext))
                .apiModule(new ApiModule(appContext))
                .storageModule(new StorageModule())
                .domainModule(new DomainModule())
                .build();
    }

    public StoresComponent initStoresComponent() {
        storesComponent = appComponent.plusStoresComponent(new StoresModule());
        return storesComponent;
    }

    public void releaseStoresComponent() {
        storesComponent = null;
    }
}
