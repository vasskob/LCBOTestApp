package com.obezhenar.lcbotestapp.api.stores;

import com.obezhenar.lcbotestapp.BuildConfig;
import com.obezhenar.lcbotestapp.domain.entiry.ApiResponse;
import com.obezhenar.lcbotestapp.domain.entiry.Inventory;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.domain.entiry.Store;

import java.util.List;

import dagger.Provides;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StoresService {
    String AUTH_TOKEN = "Authorization: Token " + BuildConfig.LCBO_API_KEY;

    @GET("/stores")
    @Headers(AUTH_TOKEN)
    Call<ApiResponse<List<Store>>> loadStores(
            @Query("where")
                    String where,
            @Query("page")
                    Integer pageNumber
    );

    @GET("/stores/{id}")
    @Headers(AUTH_TOKEN)
    Call<ApiResponse<Store>> loadStoreById(
            @Path("id") Long id
    );

    @GET("/stores/{id}/products")
    @Headers(AUTH_TOKEN)
    Call<ApiResponse<List<Product>>> loadProductsInStore(
            @Path("id") long storeId);

    @GET("/stores/{store_id}/products/{product_id}/inventory")
    @Headers(AUTH_TOKEN)
    Call<ApiResponse<Inventory>> loadInventoryFromProductInStore(
            @Path("store_id") long storeId,
            @Path("product_id") long productId);
}