package com.obezhenar.lcbotestapp.domain.di;

import android.content.Context;
import android.view.View;

import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.domain.stores.interactor.LoadStoresInteractor;

import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;

@Module
public class DomainModule {

    @Provides
    @Singleton
    @Named("loadStoresInteractor")
    public Interactor<Void, Observable<List<Store>>> provideLoadStoresInteractor(Context context) {
        return new LoadStoresInteractor();
    }
}
