package com.obezhenar.lcbotestapp.screens.products.di;

import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.all_products.model.request.LoadAllProductsRequestModel;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.domain.products_in_store.model.request.ProductsInStoreRequestModel;
import com.obezhenar.lcbotestapp.screens.products.model.PrductToViewModelMapper;
import com.obezhenar.lcbotestapp.screens.products.presenter.ProductsPresenter;
import com.obezhenar.lcbotestapp.screens.products.presenter.ProductsPresenterImpl;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import rx.Observable;

@Module
public class ProductsModule {

    @Provides
    @ProductsScope
    public ProductsPresenter provideProductsPresenter(
            Interactor<ProductsInStoreRequestModel, Observable<List<Product>>> loadProductsByStoreIdInteractor,
            Interactor<LoadAllProductsRequestModel, Observable<List<Product>>> loadAllProductsInteractor) {
        return new ProductsPresenterImpl(
                loadProductsByStoreIdInteractor,
                loadAllProductsInteractor,
                new PrductToViewModelMapper()
        );
    }
}
