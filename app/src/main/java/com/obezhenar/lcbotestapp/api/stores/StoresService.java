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
            @Query("has_wheelchair_accessability")
                    Boolean hasWheelChairAccessability,
            @Query("has_bilingual_services")
                    Boolean hasBilingualServices,
            @Query("has_parking")
                    Boolean hasParking,
            @Query("has_tasting_bar")
                    Boolean hasTastingBar,
            @Query("has_beer_cold_room")
                    Boolean hasBeerColdRoom,
            @Query("has_beer_cold_room")
                    Boolean hasVintagesCorner,
            @Query("page")
                    Integer pageNumber
    );
}