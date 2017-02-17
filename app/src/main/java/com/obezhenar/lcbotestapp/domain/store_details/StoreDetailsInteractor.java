package com.obezhenar.lcbotestapp.domain.store_details;

import com.obezhenar.lcbotestapp.api.stores.StoresService;
import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.SingleStoreApiResponse;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.storage.base.Repository;
import com.obezhenar.lcbotestapp.storage.base.StoreSpecificationFactory;

import java.io.IOException;

import retrofit2.Response;
import rx.Observable;

public class StoreDetailsInteractor implements Interactor<Long, Observable<Store>> {
    private StoreSpecificationFactory specificationFactory;
    private StoresService storesService;
    private Repository<Store> storeRepository;

    public StoreDetailsInteractor(StoreSpecificationFactory specificationFactory, StoresService storesService, Repository<Store> storeRepository) {
        this.specificationFactory = specificationFactory;
        this.storesService = storesService;
        this.storeRepository = storeRepository;
    }

    @Override
    public Observable<Store> invoke(Long data) {
        return Observable.create(subscriber -> {
            updateStoreFromApi(data);
            subscriber.onNext(storeRepository.query(
                    specificationFactory.createStoreByIdSpecification(data)).get(0));
        });
    }

    private void updateStoreFromApi(Long data) {
        try {
            Response<SingleStoreApiResponse> response = storesService.loadStoreById(data).execute();
            if (response.isSuccessful())
                storeRepository.update(response.body().getStore());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
