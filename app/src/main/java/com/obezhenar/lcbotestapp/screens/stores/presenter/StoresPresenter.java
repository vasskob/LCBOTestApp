package com.obezhenar.lcbotestapp.screens.stores.presenter;

import android.support.annotation.NonNull;

import com.obezhenar.lcbotestapp.screens.stores.model.StoreModel;
import com.obezhenar.lcbotestapp.screens.stores.view.StoresView;

public interface StoresPresenter {
    void onStoreClick(StoreModel store);

    void onLoadMore();

    void attach(@NonNull StoresView view);

    void release();
}
