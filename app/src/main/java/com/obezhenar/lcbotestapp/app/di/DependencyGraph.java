package com.obezhenar.lcbotestapp.app.di;

import android.content.Context;

import com.obezhenar.lcbotestapp.api.di.ApiModule;
import com.obezhenar.lcbotestapp.domain.di.DomainModule;
import com.obezhenar.lcbotestapp.screens.product_details.di.ProductDetailsComponent;
import com.obezhenar.lcbotestapp.screens.product_details.di.ProductDetailsModule;
import com.obezhenar.lcbotestapp.screens.products.di.ProductsComponent;
import com.obezhenar.lcbotestapp.screens.products.di.ProductsModule;
import com.obezhenar.lcbotestapp.screens.search.di.SearchByProductsComponent;
import com.obezhenar.lcbotestapp.screens.search.di.SearchByProductsModule;
import com.obezhenar.lcbotestapp.screens.store_details.di.StoreDetailsComponent;
import com.obezhenar.lcbotestapp.screens.store_details.di.StoreDetailsModule;
import com.obezhenar.lcbotestapp.screens.stores.di.StoresComponent;
import com.obezhenar.lcbotestapp.screens.stores.di.StoresModule;
import com.obezhenar.lcbotestapp.storage.di.StorageModule;

import java.util.ArrayList;
import java.util.List;

public class DependencyGraph {
    private Context appContext;
    private AppComponent appComponent;
    private StoresComponent storesComponent;
    private StoreDetailsComponent storeDetailsComponent;
    private List<ProductsComponent> productsComponents = new ArrayList<>();
    private ProductDetailsComponent productDetailsComponent;
    private SearchByProductsComponent searchByProducts;

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
        ProductsComponent productsComponent = appComponent.plusProductsComponent(new ProductsModule());
        productsComponents.add(productsComponent);
        return productsComponent;
    }

    public void releaseProductsComponent() {
        if (productsComponents.size() > 0)
            productsComponents.clear();
    }

    public ProductDetailsComponent initProductDetailsComponent() {
        if (productDetailsComponent == null)
            productDetailsComponent = appComponent.plusProductDetailsComponent(new ProductDetailsModule());
        return productDetailsComponent;
    }

    public void releaseProductDetailsComponent() {
        productDetailsComponent = null;
    }

    public SearchByProductsComponent initSearchByProductsComponent() {
        if(searchByProducts == null)
            searchByProducts = appComponent.plusSearchByProductsComponent(new SearchByProductsModule());
        return searchByProducts;
    }

    public void releaseSearchByProductsComponent() {
        searchByProducts = null;
    }
}
