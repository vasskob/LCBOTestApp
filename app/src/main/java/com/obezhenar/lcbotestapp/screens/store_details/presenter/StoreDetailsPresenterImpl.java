package com.obezhenar.lcbotestapp.screens.store_details.presenter;

import com.obezhenar.lcbotestapp.common.util.Mapper;
import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.screens.store_details.model.StoreDetailsViewModel;
import com.obezhenar.lcbotestapp.screens.store_details.view.StoreDetailsView;
import com.obezhenar.lcbotestapp.screens.stores.presenter.StoresPresenterImpl;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class StoreDetailsPresenterImpl extends Subscriber<StoreDetailsViewModel> implements StoreDetailsPresenter {
    private StoreDetailsView view;
    private Interactor<Long, Observable<Store>> loadStoreInteractor;
    private Mapper<Store, StoreDetailsViewModel> viewModelMapper;

    public StoreDetailsPresenterImpl(
            Interactor<Long, Observable<Store>> loadStoreInteractor,
            Mapper<Store, StoreDetailsViewModel> viewModelMapper) {
        this.loadStoreInteractor = loadStoreInteractor;
        this.viewModelMapper = viewModelMapper;
    }

    @Override
    public void attachToView(StoreDetailsView view) {
        this.view = view;
    }

    @Override
    public void loadStore(long id) {
        view.setShowProgress(true);
        loadStoreInteractor.invoke(id)
                .subscribeOn(Schedulers.newThread())
                .map(store -> viewModelMapper.map(store))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }

    @Override
    public void onCompleted() {
        view.setShowProgress(false);
    }

    @Override
    public void onError(Throwable e) {
        view.displayError(e);
        e.printStackTrace();
    }

    @Override
    public void onNext(StoreDetailsViewModel model) {
        view.displayStoreDetails(model);
    }

    @Override
    public void makeCall() {

    }

    @Override
    public void onShowProductsClick() {

    }
}
