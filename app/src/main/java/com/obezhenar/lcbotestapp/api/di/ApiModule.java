package com.obezhenar.lcbotestapp.api.di;

import android.content.Context;

import com.obezhenar.lcbotestapp.BuildConfig;
import com.obezhenar.lcbotestapp.R;
import com.obezhenar.lcbotestapp.api.stores.ProductsService;
import com.obezhenar.lcbotestapp.api.stores.StoresService;
import com.obezhenar.lcbotestapp.domain.entiry.Store;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    private Retrofit retrofit;
    private Context context;

    public ApiModule(Context context) {
        this.context = context;
        retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.api_url))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public StoresService provideStoresService() {
        return retrofit.create(StoresService.class);
    }

    @Provides
    @Singleton
    public ProductsService provideProductsService() {
        return retrofit.create(ProductsService.class);
    }
}
