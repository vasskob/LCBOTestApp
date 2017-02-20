package com.obezhenar.lcbotestapp.domain.di;

import com.obezhenar.lcbotestapp.api.ProductsService;
import com.obezhenar.lcbotestapp.api.StoresService;
import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.all_products.LoadAllProductsInteractor;
import com.obezhenar.lcbotestapp.domain.all_products.model.request.LoadAllProductsRequestModel;
import com.obezhenar.lcbotestapp.domain.entiry.Inventory;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.domain.product_details.LoadProductDetailsInteractor;
import com.obezhenar.lcbotestapp.domain.products_in_store.ProductsInStoreInteractor;
import com.obezhenar.lcbotestapp.domain.products_in_store.model.request.ProductsInStoreRequestModel;
import com.obezhenar.lcbotestapp.domain.store_details.StoreDetailsInteractor;
import com.obezhenar.lcbotestapp.domain.stores.interactor.LoadStoresInteractor;
import com.obezhenar.lcbotestapp.domain.stores.model.request.LoadStoresRequestModel;
import com.obezhenar.lcbotestapp.storage.base.InventorySpecificationFactory;
import com.obezhenar.lcbotestapp.storage.base.ProductSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.base.Repository;
import com.obezhenar.lcbotestapp.storage.base.StoreSpecificationFactory;

import java.util.List;

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
    public Interactor<ProductsInStoreRequestModel, Observable<List<Product>>>
    provideLoadProductInStoreInteractor(
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

    @Provides
    @Singleton
    public Interactor<LoadAllProductsRequestModel, Observable<List<Product>>>
    provideLoadAllProductsRequestModelObservableInteractor(
            ProductsService productsService,
            Repository<Product> productRepository,
            ProductSpecificationFactory productSpecificationFactory
    ) {
        return new LoadAllProductsInteractor(
                productsService,
                productRepository,
                productSpecificationFactory
        );
    }

    @Provides
    @Singleton
    public Interactor<Long, Observable<Product>> provideLoadProductDetailsInteractor(
            ProductSpecificationFactory productSpecificationFactory,
            ProductsService service,
            Repository<Product> productRepository
    ) {
        return new LoadProductDetailsInteractor(
                productSpecificationFactory,
                service,
                productRepository
        );
    }
}
