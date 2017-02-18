package com.obezhenar.lcbotestapp.screens.store_details.presenter;

import com.obezhenar.lcbotestapp.screens.store_details.model.StoreDetailsViewModel;
import com.obezhenar.lcbotestapp.screens.store_details.view.StoreDetailsView;

public interface StoreDetailsPresenter {
    void attachToView(StoreDetailsView view);

    void loadStore(long id);

    void makeCall();

    void onShowProductsClick();
}
