package com.obezhenar.lcbotestapp.api.stores;

import com.obezhenar.lcbotestapp.BuildConfig;
import com.obezhenar.lcbotestapp.domain.entiry.ApiResponse;
import com.obezhenar.lcbotestapp.domain.entiry.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ProductsService {
    String AUTH_TOKEN = "Authorization: Token " + BuildConfig.LCBO_API_KEY;

    @GET("/products")
    @Headers(AUTH_TOKEN)
    Call<ApiResponse<List<Product>>> loadAllProductsByQuery(
            @Query("q") String where);
}
