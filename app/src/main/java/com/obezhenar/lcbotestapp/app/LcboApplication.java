package com.obezhenar.lcbotestapp.app;

import android.app.Application;

import com.obezhenar.lcbotestapp.api.ApiModule;
import com.obezhenar.lcbotestapp.app.di.AppComponent;
import com.obezhenar.lcbotestapp.app.di.AppModule;
import com.obezhenar.lcbotestapp.app.di.DaggerAppComponent;
import com.obezhenar.lcbotestapp.storage.StorageModule;

public class LcboApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .storageModule(new StorageModule())
                .build();
    }
}
