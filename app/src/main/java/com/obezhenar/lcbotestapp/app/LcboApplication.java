package com.obezhenar.lcbotestapp.app;

import android.app.Application;

import com.obezhenar.lcbotestapp.app.di.DependencyGraph;

public class LcboApplication extends Application {
    public static DependencyGraph dependencyGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        dependencyGraph = new DependencyGraph(this);
    }
}
