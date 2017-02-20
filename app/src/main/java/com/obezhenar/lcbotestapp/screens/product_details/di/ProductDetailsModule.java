package com.obezhenar.lcbotestapp.screens.product_details.di;

import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.screens.product_details.model.ProductDetailsViewModelMapper;
import com.obezhenar.lcbotestapp.screens.product_details.presenter.ProductDetailsPresenter;
import com.obezhenar.lcbotestapp.screens.product_details.presenter.ProductDetailsPresenterImpl;

import dagger.Module;
import dagger.Provides;
import rx.Observable;

@Module
public class ProductDetailsModule {

    @Provides
    @ProductDetailsScope
    public ProductDetailsPresenter provideProductDetailsPresenter(
            Interactor<Long, Observable<Product>> loadProductInteractor
    ) {
        return new ProductDetailsPresenterImpl(loadProductInteractor, new ProductDetailsViewModelMapper());
    }
}
