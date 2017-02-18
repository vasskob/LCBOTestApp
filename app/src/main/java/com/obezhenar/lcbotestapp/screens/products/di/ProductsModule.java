package com.obezhenar.lcbotestapp.screens.products.di;

import com.obezhenar.lcbotestapp.common.util.Mapper;
import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.screens.products.model.PrductToViewModelMapper;
import com.obezhenar.lcbotestapp.screens.products.model.ProductViewModel;
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
            Interactor<Long, Observable<List<Product>>> loadProductsByStoreIdInteractor) {
        return new ProductsPresenterImpl(
                loadProductsByStoreIdInteractor,
                new PrductToViewModelMapper()
        );
    }
}
