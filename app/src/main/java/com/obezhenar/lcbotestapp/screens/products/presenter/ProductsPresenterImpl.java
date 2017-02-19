package com.obezhenar.lcbotestapp.screens.products.presenter;

import android.support.annotation.NonNull;

import com.obezhenar.lcbotestapp.common.util.Mapper;
import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.all_products.model.request.LoadAllProductsRequestModel;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.domain.products_in_store.model.request.ProductsInStoreRequestModel;
import com.obezhenar.lcbotestapp.screens.eventbus.ShowProductDetailsEvent;
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
    private Interactor<ProductsInStoreRequestModel, Observable<List<Product>>> loadProductsByStoreIdInteractor;
    private Interactor<LoadAllProductsRequestModel, Observable<List<Product>>> loadAllProductsInteractor;
    private Mapper<Product, ProductViewModel> productToViewModelMapper;
    private ProductsView view;

    public ProductsPresenterImpl(
            Interactor<ProductsInStoreRequestModel, Observable<List<Product>>> loadProductsByStoreIdInteractor,
            Interactor<LoadAllProductsRequestModel, Observable<List<Product>>> loadAllProductsInteractor,
            Mapper<Product, ProductViewModel> productToViewModelMapper
    ) {
        this.loadProductsByStoreIdInteractor = loadProductsByStoreIdInteractor;
        this.loadAllProductsInteractor = loadAllProductsInteractor;
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

    // use -1 as store id to load products in all stores
    @Override
    public void loadProductsForStore(long storeId, int page, String productCategory) {
        view.setShowProgress(true);
        Observable<List<Product>> productsObservable;
        if (storeId == -1)
            productsObservable = loadAllProductsInteractor.invoke(
                    new LoadAllProductsRequestModel(
                            productCategory, page
                    )
            );
        else
            productsObservable = loadProductsByStoreIdInteractor.invoke(
                    new ProductsInStoreRequestModel(
                            page, storeId, productCategory)
            );
        productsObservable
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
    public void loadMore() {

    }

    @Override
    public void onCompleted() {
        view.setShowProgress(false);
    }

    @Override
    public void onError(Throwable e) {
        view.displayNoProducts();
        e.printStackTrace();
    }

    @Override
    public void onNext(List<ProductViewModel> products) {
        if (products != null && !products.isEmpty())
            view.displayProducts(products);
        else view.displayNoProducts();
    }
}
