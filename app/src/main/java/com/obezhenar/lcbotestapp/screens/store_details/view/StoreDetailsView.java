package com.obezhenar.lcbotestapp.screens.store_details.view;

import com.obezhenar.lcbotestapp.screens.store_details.model.StoreDetailsViewModel;

public interface StoreDetailsView {
    void displayStoreDetails(StoreDetailsViewModel model);

    void displayError(Throwable throwable);

    void setShowProgress(boolean showProgress);
}
