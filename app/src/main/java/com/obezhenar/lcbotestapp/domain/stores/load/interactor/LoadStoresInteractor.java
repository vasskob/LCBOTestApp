package com.obezhenar.lcbotestapp.domain.stores.load.interactor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.obezhenar.lcbotestapp.api.stores.StoresService;
import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.domain.entiry.StoresResponse;
import com.obezhenar.lcbotestapp.domain.stores.load.model.request.LoadStoresRequestModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class LoadStoresInteractor implements Interactor<LoadStoresRequestModel, Observable<List<Store>>> {
    private StoresService storesService;
    private String apiKey;

    public LoadStoresInteractor(StoresService storesService, String apiKey) {
        this.storesService = storesService;
        this.apiKey = apiKey;
    }

    @Override
    public Observable<List<Store>> invoke(@NonNull LoadStoresRequestModel data) {
        return storesService.loadStores(
                "Token " + apiKey,
                data.getHasWheelChairAccessibility(),
                data.getHasBilingualServices(),
                data.getHasParking(),
                data.getHasTastingBar(),
                data.getHasBeerColdRoom(),
                data.getHasVintagesCorner(),
                data.getPageNumber()
        ).map(StoresResponse::getStores);
    }
}
