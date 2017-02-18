package com.obezhenar.lcbotestapp.domain.di;

import android.content.Context;

import com.obezhenar.lcbotestapp.R;
import com.obezhenar.lcbotestapp.api.stores.StoresService;
import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.Inventory;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.domain.products.ProductsInStoreInteractor;
import com.obezhenar.lcbotestapp.domain.store_details.StoreDetailsInteractor;
import com.obezhenar.lcbotestapp.domain.stores.interactor.LoadStoresInteractor;
import com.obezhenar.lcbotestapp.domain.stores.model.request.LoadStoresRequestModel;
import com.obezhenar.lcbotestapp.storage.base.InventorySpecificationFactory;
import com.obezhenar.lcbotestapp.storage.base.ProductSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.base.Repository;
import com.obezhenar.lcbotestapp.storage.base.StoreSpecificationFactory;

import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Observable;

@Module
public class DomainModule {

    @Provides
    @Singleton
    public Interactor<LoadStoresRequestModel, Observable<List<Store>>> provideLoadStoresInteractor(
            StoresService storesService,
            Repository<Store> storeRepository,
            StoreSpecificationFactory specificationFactory) {
        return new LoadStoresInteractor(
                storesService,
                storeRepository,
                specificationFactory);
    }

    @Provides
    @Singleton
    public Interactor<Long, Observable<Store>> provideLoadStoreDetailsInteractor(
            StoreSpecificationFactory specificationFactory,
            StoresService storesService,
            Repository<Store> storeRepository
    ) {
        return new StoreDetailsInteractor(
                specificationFactory,
                storesService,
                storeRepository
        );
    }

    @Provides
    @Singleton
    public Interactor<Long, Observable<List<Product>>> provideLoadProductInStoreInteractor(
            StoresService storesService,
            ProductSpecificationFactory productSpecificationFactory,
            InventorySpecificationFactory inventorySpecificationFactory,
            Repository<Inventory> inventoryRepository,
            Repository<Product> productRepository
    ) {
        return new ProductsInStoreInteractor(
                storesService,
                productSpecificationFactory,
                inventorySpecificationFactory,
                inventoryRepository,
                productRepository
        );
    }
}
