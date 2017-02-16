package com.obezhenar.lcbotestapp.screens.stores.presenter;

import android.support.annotation.NonNull;

import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.domain.stores.load.model.request.LoadStoresRequestModel;
import com.obezhenar.lcbotestapp.screens.stores.model.StoreModel;
import com.obezhenar.lcbotestapp.screens.stores.model.StoresFilter;
import com.obezhenar.lcbotestapp.screens.stores.view.StoresView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class StoresPresenterImpl implements StoresPresenter {
    private Interactor<LoadStoresRequestModel, Observable<List<Store>>> loadStoresInteractor;
    private StoresView view;
    private LoadStoresRequestModel loadStoresRequestModel = new LoadStoresRequestModel();

    @Inject
    public StoresPresenterImpl(Interactor<LoadStoresRequestModel, Observable<List<Store>>> loadStoresInteractor) {
        this.loadStoresInteractor = loadStoresInteractor;
    }

    @Override
    public void onStoreClick(StoreModel store) {

    }

    @Override
    public void onLoadMore() {
        loadStoresRequestModel.setPageNumber(loadStoresRequestModel.getPageNumber() + 1);
        load();
    }

    @Override
    public void loadStores(StoresFilter filter) {
        view.clearList();
        loadStoresRequestModel.setHasBeerColdRoom(filter.getHasBeerColdRoom());
        loadStoresRequestModel.setHasBilingualServices(filter.getHasBilingualServices());
        loadStoresRequestModel.setHasParking(filter.getHasParking());
        loadStoresRequestModel.setHasTastingBar(filter.getHasTastingBar());
        loadStoresRequestModel.setHasVintagesCorner(filter.getHasVintagesCorner());
        loadStoresRequestModel.setHasWheelChairAccessibility(filter.getHasWheelChairAccessibility());
        load();
    }

    private void load() {
        view.setShowProgress(true);
        loadStoresInteractor.invoke(loadStoresRequestModel)
                .subscribeOn(Schedulers.newThread())
                .map(stores -> mapToStoreModel(stores))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        stores -> {
                            view.setShowProgress(false);
                            view.displayStores(stores);
                        },
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
