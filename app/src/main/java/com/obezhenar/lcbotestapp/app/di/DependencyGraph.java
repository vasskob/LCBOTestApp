package com.obezhenar.lcbotestapp.app.di;

import android.content.Context;

import com.obezhenar.lcbotestapp.api.di.ApiModule;
import com.obezhenar.lcbotestapp.domain.di.DomainModule;
import com.obezhenar.lcbotestapp.screens.products.di.ProductsComponent;
import com.obezhenar.lcbotestapp.screens.products.di.ProductsModule;
import com.obezhenar.lcbotestapp.screens.store_details.di.StoreDetailsComponent;
import com.obezhenar.lcbotestapp.screens.store_details.di.StoreDetailsModule;
import com.obezhenar.lcbotestapp.screens.stores.di.StoresComponent;
import com.obezhenar.lcbotestapp.screens.stores.di.StoresModule;
import com.obezhenar.lcbotestapp.storage.di.StorageModule;

public class DependencyGraph {
    private Context appContext;
    private AppComponent appComponent;
    private StoresComponent storesComponent;
    private StoreDetailsComponent storeDetailsComponent;
    private ProductsComponent productsComponent;

    public DependencyGraph(Context appContext) {
        this.appContext = appContext;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(appContext))
                .apiModule(new ApiModule(appContext))
                .storageModule(new StorageModule(appContext))
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

    public StoreDetailsComponent initStoreDetailsComponent() {
        if (storeDetailsComponent == null)
            storeDetailsComponent = appComponent.plusStoreDetailsComponent(new StoreDetailsModule());
        return storeDetailsComponent;
    }

    public void releaseStoreDetailsComponent() {
        storeDetailsComponent = null;
    }

    public ProductsComponent initProductComponent() {
        if (productsComponent == null)
            productsComponent = appComponent.plusProductsComponent(new ProductsModule());
        return productsComponent;
    }

    public void releaseProductsComponent() {
        productsComponent = null;
    }
}
