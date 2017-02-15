package com.obezhenar.lcbotestapp.app;

import android.app.Application;

import com.obezhenar.lcbotestapp.api.ApiModule;
import com.obezhenar.lcbotestapp.app.di.AppModule;
import com.obezhenar.lcbotestapp.app.di.DaggerAppComponent;
import com.obezhenar.lcbotestapp.app.di.DependencyGraph;
import com.obezhenar.lcbotestapp.storage.StorageModule;

public class LcboApplication extends Application {
    public static DependencyGraph dependencyGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        dependencyGraph = new DependencyGraph(this);
    }
}
