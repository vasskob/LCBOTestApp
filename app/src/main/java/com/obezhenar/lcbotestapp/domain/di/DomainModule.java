package com.obezhenar.lcbotestapp.domain.di;

import android.content.Context;

import com.obezhenar.lcbotestapp.R;
import com.obezhenar.lcbotestapp.api.stores.StoresService;
import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.domain.stores.load.interactor.LoadStoresInteractor;
import com.obezhenar.lcbotestapp.domain.stores.load.model.request.LoadStoresRequestModel;

import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Observable;

@Module
public class DomainModule {

    @Provides
    @Singleton
    public Interactor<LoadStoresRequestModel, Observable<List<Store>>> provideLoadStoresInteractor(
            StoresService storesService,
            Context context) {
        return new LoadStoresInteractor(storesService, context.getString(R.string.lcbo_api_key));
    }
}
