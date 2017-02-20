package com.obezhenar.lcbotestapp.screens.search.di;

import com.obezhenar.lcbotestapp.common.util.Mapper;
import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.domain.search.ProductsSearchRequestModel;
import com.obezhenar.lcbotestapp.screens.products.model.PrductToViewModelMapper;
import com.obezhenar.lcbotestapp.screens.products.model.ProductViewModel;
import com.obezhenar.lcbotestapp.screens.search.presenter.SearchByProductsPresenter;
import com.obezhenar.lcbotestapp.screens.search.presenter.SearchByProductsPresenterImpl;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import rx.Observable;

@Module
public class SearchByProductsModule {

    @Provides
    @SearchByProductsScope
    public SearchByProductsPresenter prvideSearchByProductsPresenter(
            Interactor<ProductsSearchRequestModel, Observable<List<Product>>> searchInteractor
    ) {
        return new SearchByProductsPresenterImpl(searchInteractor, new PrductToViewModelMapper());
    }
}
