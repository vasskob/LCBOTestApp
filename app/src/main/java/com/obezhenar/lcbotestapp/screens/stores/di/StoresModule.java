package com.obezhenar.lcbotestapp.screens.stores.di;

import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.domain.stores.load.model.request.LoadStoresRequestModel;
import com.obezhenar.lcbotestapp.screens.stores.model.StoreModel;
import com.obezhenar.lcbotestapp.screens.stores.presenter.StoresPresenter;
import com.obezhenar.lcbotestapp.screens.stores.presenter.StoresPresenterImpl;

import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import rx.Observable;

@Module
public class StoresModule {
    @Provides
    @StoresScope
    public StoresPresenter provideStoresPresenter(
            Interactor<LoadStoresRequestModel, Observable<List<Store>>> loadStoresInteractor) {
        return new StoresPresenterImpl(loadStoresInteractor);
    }
}
