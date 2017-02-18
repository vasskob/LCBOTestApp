package com.obezhenar.lcbotestapp.domain.stores.interactor;

import android.support.annotation.NonNull;

import com.obezhenar.lcbotestapp.api.stores.StoresService;
import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.ApiResponse;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.domain.stores.model.request.LoadStoresRequestModel;
import com.obezhenar.lcbotestapp.storage.base.Repository;
import com.obezhenar.lcbotestapp.storage.base.Specification;
import com.obezhenar.lcbotestapp.storage.base.StoreSpecificationFactory;
import com.obezhenar.lcbotestapp.storage.greendao.specifications.store.StoreFilterCriteria;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;
import rx.Observable;

public class LoadStoresInteractor implements Interactor<LoadStoresRequestModel, Observable<List<Store>>> {
    private final int ITEMS_PER_PAGE = 20;
    private StoresService storesService;
    private Repository<Store> storeRepository;
    private StoreSpecificationFactory specificationFactory;

    public LoadStoresInteractor(
            StoresService storesService,
            Repository<Store> storeRepository,
            StoreSpecificationFactory specificationFactory) {
        this.storesService = storesService;
        this.storeRepository = storeRepository;
        this.specificationFactory = specificationFactory;
    }

    @Override
    public Observable<List<Store>> invoke(@NonNull LoadStoresRequestModel data) {
        return Observable.create(subscriber -> {
            // retrieving data from api
            List<Store> stores = fetchStoresFromApi(data);
            // caching
            if (stores != null)
                storeRepository.addAll(stores);
            // fetching data from local storage
            subscriber.onNext(storeRepository.query(createQueryByPage(data)));
        });
    }

    private List<Store> fetchStoresFromApi(@NonNull LoadStoresRequestModel data) {
        try {
            Response<ApiResponse<List<Store>>> response = storesService.loadStores(
                    prepareWhereCondition(data),
                    data.getPageNumber()
            ).execute();
            if (response.isSuccessful())
                return response.body().getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String prepareWhereCondition(LoadStoresRequestModel data) {
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
        if (whereCondition.length() == 0)
            return null;
        return whereCondition.toString();
    }

    private Specification createQueryByPage(LoadStoresRequestModel data) {
        final long startIndex = (data.getPageNumber() - 1) * ITEMS_PER_PAGE;
        return specificationFactory.createPaginationSpecification(
                new StoreFilterCriteria(
                        data.getHasWheelChairAccessibility(),
                        data.getHasBilingualServices(),
                        data.getHasParking(),
                        data.getHasTastingBar(),
                        data.getHasBeerColdRoom(),
                        data.getHasVintagesCorner(),
                        startIndex,
                        startIndex + ITEMS_PER_PAGE));
    }
}
