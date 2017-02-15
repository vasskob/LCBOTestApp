package com.obezhenar.lcbotestapp.domain.stores.interactor;

import com.obezhenar.lcbotestapp.domain.Interactor;
import com.obezhenar.lcbotestapp.domain.entiry.Store;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class LoadStoresInteractor implements Interactor<Void, Observable<List<Store>>> {

    @Override
    public Observable<List<Store>> invoke(Void data) {
        List<Store> stores = new ArrayList<>();
        stores.add(new Store(0, "Test Store 1", "Some Address qwerty 1", null, "Kyiv"));
        stores.add(new Store(1, "Test Store 2", "Some Address qwerty 2", null, "Helsinki"));
        stores.add(new Store(2, "Test Store 3", "Some Address qwerty 3", null, "City 17"));
        stores.add(new Store(3, "Test Store 4", "Some Address qwerty 4", null, "Moskow"));
        return Observable.just(stores);
    }
}
