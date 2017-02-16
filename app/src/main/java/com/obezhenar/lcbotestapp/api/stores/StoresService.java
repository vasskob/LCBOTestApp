package com.obezhenar.lcbotestapp.api.stores;

import com.obezhenar.lcbotestapp.domain.entiry.StoresResponse;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

public interface StoresService {
    @GET("/stores")

    Observable<StoresResponse> loadStores(
            @Header("Authorization")
                    String token,
            @Query("where")
                    String where,
            @Query("page")
                    Integer pageNumber
    );
}