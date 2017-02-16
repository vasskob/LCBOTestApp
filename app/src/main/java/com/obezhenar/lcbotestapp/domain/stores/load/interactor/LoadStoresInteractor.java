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
        // TODO: 16.02.2017 excluding filtering
        final StringBuilder whereCondition = new StringBuilder();
        if (data.getHasWheelChairAccessibility() != null)
            whereCondition.append(Store.HAS_WHEELCHAIR_ACCESSABILITY).append(",");
        if (data.getHasBeerColdRoom() != null)
            whereCondition.append(Store.HAS_BEER_COLD_ROOM).append(",");
        if (data.getHasBilingualServices() != null)
            whereCondition.append(Store.HAS_BILINGUAL_SERVICES).append(",");
        if (data.getHasParking() != null)
            whereCondition.append(Store.HAS_PARKING).append(",");
        if (data.getHasTastingBar() != null)
            whereCondition.append(Store.HAS_TASTING_BAR).append(",");
        if (data.getHasVintagesCorner() != null)
            whereCondition.append(Store.HAS_VINTAGES_CORNER).append(",");
        return storesService.loadStores(
                "Token " + apiKey,
                whereCondition.toString(),
                data.getPageNumber()
        ).map(StoresResponse::getStores);
    }
}
