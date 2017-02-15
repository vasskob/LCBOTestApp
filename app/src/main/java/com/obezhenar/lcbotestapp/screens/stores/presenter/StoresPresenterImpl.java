package com.obezhenar.lcbotestapp.screens.stores.presenter;

import android.support.annotation.NonNull;

import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.screens.stores.model.StoreModel;
import com.obezhenar.lcbotestapp.screens.stores.view.StoresView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class StoresPresenterImpl implements StoresPresenter {
    private Interactor<Void, Observable<List<Store>>> loadStoresInteractor;
    private StoresView view;

    @Inject
    public StoresPresenterImpl(Interactor<Void, Observable<List<Store>>> loadStoresInteractor) {
        this.loadStoresInteractor = loadStoresInteractor;
    }

    @Override
    public void onStoreClick(StoreModel store) {

    }

    @Override
    public void onLoadMore() {
        loadStoresInteractor.invoke(null)
                .subscribeOn(Schedulers.newThread())
                .map(stores -> mapToStoreModel(stores))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        stores -> view.displayStores(stores),
                        throwable -> view.displayError(throwable.getMessage())
                );
    }

    @Override
    public void attach(@NonNull StoresView view) {
        this.view = view;
    }

    @Override
    public void release() {

    }

    private List<StoreModel> mapToStoreModel(List<Store> stores) {
        List<StoreModel> storeModels = new ArrayList<>();
        for (Store store : stores)
            storeModels.add(convertToStoreModel(store));
        return storeModels;
    }

    private StoreModel convertToStoreModel(Store store) {
        StoreModel storeModel = new StoreModel();
        storeModel.setId(store.getId());
        storeModel.setName(store.getName());
        storeModel.setAddress(new StringBuilder()
                .append(store.getCity())
                .append(", ")
                .append(store.getAddress1())
                .toString());
        return storeModel;
    }
}
