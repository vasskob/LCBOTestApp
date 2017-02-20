package com.obezhenar.lcbotestapp.screens.product_details.presenter;

import com.obezhenar.lcbotestapp.common.util.Mapper;
import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.screens.product_details.model.ProductDetailsViewModel;
import com.obezhenar.lcbotestapp.screens.product_details.view.ProductDetailsView;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ProductDetailsPresenterImpl extends Subscriber<ProductDetailsViewModel> implements ProductDetailsPresenter {
    private Interactor<Long, Observable<Product>> loadProductInteractor;
    private Mapper<Product, ProductDetailsViewModel> mapper;

    private ProductDetailsView view;

    public ProductDetailsPresenterImpl(
            Interactor<Long, Observable<Product>> loadProductInteractor,
            Mapper<Product, ProductDetailsViewModel> mapper) {
        this.loadProductInteractor = loadProductInteractor;
        this.mapper = mapper;
    }

    @Override
    public void loadProductDetails(long productId) {
        view.setShowProgress(true);
        loadProductInteractor.invoke(productId)
                .subscribeOn(Schedulers.newThread())
                .map(product -> mapper.map(product))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }

    @Override
    public void attach(ProductDetailsView view) {
        this.view = view;
    }

    @Override
    public void onCompleted() {
        view.setShowProgress(false);
    }

    @Override
    public void onError(Throwable e) {
        view.setShowProgress(false);
        view.displayError("Cannot retrieve data");
    }

    @Override
    public void onNext(ProductDetailsViewModel product) {
        view.setShowProgress(false);
        view.displayProductDetails(product);
    }
}
