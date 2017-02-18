package com.obezhenar.lcbotestapp.screens.store_details.di;

import android.content.Context;

import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.screens.store_details.model.StoreDetailsViewModelMapper;
import com.obezhenar.lcbotestapp.screens.store_details.presenter.StoreDetailsPresenter;
import com.obezhenar.lcbotestapp.screens.store_details.presenter.StoreDetailsPresenterImpl;
import com.obezhenar.lcbotestapp.screens.store_details.view.StoreDetailsFragment;

import dagger.Module;
import dagger.Provides;
import rx.Observable;

@Module
public class StoreDetailsModule {

    @Provides
    @StoreDetailsScope
    public StoreDetailsPresenter provideStoreDetailsPresenter(
            Interactor<Long, Observable<Store>> loadStoreInteractor,
            Context context
    ) {
        return new StoreDetailsPresenterImpl(
                loadStoreInteractor,
                new StoreDetailsViewModelMapper(context));
    }
}
