package com.obezhenar.lcbotestapp.screens.products.presenter;

import android.support.annotation.NonNull;

import com.obezhenar.lcbotestapp.common.util.Mapper;
import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.screens.eventbus.ShowProductDetailsEvent;
import com.obezhenar.lcbotestapp.screens.eventbus.ShowStoreProductsEvent;
import com.obezhenar.lcbotestapp.screens.products.model.ProductViewModel;
import com.obezhenar.lcbotestapp.screens.products.view.ProductsView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ProductsPresenterImpl extends Subscriber<List<ProductViewModel>> implements ProductsPresenter {
    private Interactor<Long, Observable<List<Product>>> loadProductsByStoreIdInteractor;
    private Mapper<Product, ProductViewModel> productToViewModelMapper;
    private ProductsView view;

    public ProductsPresenterImpl(
            Interactor<Long, Observable<List<Product>>> loadProductsByStoreIdInteractor,
            Mapper<Product, ProductViewModel> productToViewModelMapper
    ) {
        this.loadProductsByStoreIdInteractor = loadProductsByStoreIdInteractor;
        this.productToViewModelMapper = productToViewModelMapper;
    }

    @Override
    public void attachToView(@NonNull ProductsView view) {
        this.view = view;
    }

    @Override
    public void onProductClick(@NonNull ProductViewModel productViewModel) {
        EventBus.getDefault().post(new ShowProductDetailsEvent(productViewModel.getId()));
    }

    @Override
    public void loadProductsForStore(long storeId) {
        view.setShowProgress(true);
        loadProductsByStoreIdInteractor.invoke(storeId)
                .subscribeOn(Schedulers.newThread())
                .flatMap(products -> {
                    List<ProductViewModel> productViewModels = new ArrayList<>();
                    for (Product product : products)
                        productViewModels.add(productToViewModelMapper.map(product));
                    return Observable.just(productViewModels);
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }

    @Override
    public void loadAllProducts() {

    }

    @Override
    public void onCompleted() {
        view.setShowProgress(false);
    }

    @Override
    public void onError(Throwable e) {
        view.displayNoProducts();
    }

    @Override
    public void onNext(List<ProductViewModel> products) {
        if (products != null && !products.isEmpty())
            view.displayProducts(products);
        else view.displayNoProducts();
    }
}
