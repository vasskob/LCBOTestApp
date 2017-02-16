package com.obezhenar.lcbotestapp.screens.stores.view;

import com.obezhenar.lcbotestapp.screens.stores.model.StoreModel;

import java.util.List;

public interface StoresView {
    void displayStores(List<StoreModel> stores);

    void displayError(String message);

    void showStoreDetails(StoreModel storeModel);

    void setShowProgress(boolean showProgress);

    void clearList();
}
