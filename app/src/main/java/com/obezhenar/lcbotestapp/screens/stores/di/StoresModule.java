package com.obezhenar.lcbotestapp.screens.stores.di;

import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.screens.stores.model.StoreModel;
import com.obezhenar.lcbotestapp.screens.stores.presenter.StoresPresenter;
import com.obezhenar.lcbotestapp.screens.stores.presenter.StoresPresenterImpl;

import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;

@Module
public class StoresModule {
    @Provides
    @StoresScope
    public StoresPresenter provideStoresPresenter(
            @Named("loadStoresInteractor")
                    Interactor<Void, Observable<List<Store>>> loadStoresInteractor) {
        return new StoresPresenterImpl(loadStoresInteractor);
    }
}
