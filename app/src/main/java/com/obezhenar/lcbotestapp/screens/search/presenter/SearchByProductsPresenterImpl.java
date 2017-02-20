package com.obezhenar.lcbotestapp.screens.search.presenter;

import com.obezhenar.lcbotestapp.common.util.Mapper;
import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.domain.search.ProductsSearchRequestModel;
import com.obezhenar.lcbotestapp.screens.products.model.ProductViewModel;
import com.obezhenar.lcbotestapp.screens.search.view.SearchByProductsView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchByProductsPresenterImpl extends Subscriber<List<Product>>
        implements SearchByProductsPresenter {
    private Interactor<ProductsSearchRequestModel, Observable<List<Product>>> searchInteractor;
    private Mapper<Product, ProductViewModel> mapper;
    private SearchByProductsView view;
    private ProductsSearchRequestModel requestModel = new ProductsSearchRequestModel();

    public SearchByProductsPresenterImpl(
            Interactor<ProductsSearchRequestModel, Observable<List<Product>>> searchInteractor,
            Mapper<Product, ProductViewModel> mapper) {
        this.searchInteractor = searchInteractor;
        this.mapper = mapper;
    }

    @Override
    public void attach(SearchByProductsView view) {
        this.view = view;
    }

    @Override
    public void onSearchQuery(String query) {
        requestModel.setQuery(query);
        requestModel.setPage(1);
        load();
    }

    private void load() {
        searchInteractor.invoke(requestModel)
                .subscribeOn(Schedulers.newThread())
                .debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }

    @Override
    public void onFilterSettingsChanged(boolean isSeasonal, boolean isKosher, boolean hasLimitedTimeOffer) {
        requestModel.setSeasonal(isSeasonal);
        requestModel.setKosher(isKosher);
        requestModel.setHasLimitedOffer(hasLimitedTimeOffer);
        requestModel.setPage(1);
        load();
    }

    @Override
    public void loadMore() {
        requestModel.setPage(requestModel.getPage() + 1);
        load();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        view.setShowProgress(false);
        view.showNoResults();
    }

    @Override
    public void onNext(List<Product> products) {
        List<ProductViewModel> viewModels = new ArrayList<>();
        for (Product product : products)
            viewModels.add(mapper.map(product));
        view.setShowProgress(false);
        if (requestModel.getPage() == 1)
            view.displaySearchResults(viewModels);
        else
            view.displayMore(viewModels);
    }
}
