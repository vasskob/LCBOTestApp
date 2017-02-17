package com.obezhenar.lcbotestapp.api.stores;

import com.obezhenar.lcbotestapp.BuildConfig;
import com.obezhenar.lcbotestapp.domain.entiry.SingleStoreApiResponse;
import com.obezhenar.lcbotestapp.domain.entiry.Store;
import com.obezhenar.lcbotestapp.domain.entiry.StoresResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface StoresService {
    String AUTH_TOKEN = "Authorization: Token " + BuildConfig.LCBO_API_KEY;

    @GET("/stores")
    @Headers(AUTH_TOKEN)
    Call<StoresResponse> loadStores(
            @Query("where")
                    String where,
            @Query("page")
                    Integer pageNumber
    );

    @GET("/stores/{id}")
    @Headers(AUTH_TOKEN)
    Call<SingleStoreApiResponse> loadStoreById(
            @Path("id") Long id
    );
}