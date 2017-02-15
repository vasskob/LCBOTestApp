package com.obezhenar.lcbotestapp.app.di;

import com.obezhenar.lcbotestapp.api.ApiModule;
import com.obezhenar.lcbotestapp.storage.StorageModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {
        AppModule.class,
        StorageModule.class,
        ApiModule.class
})
@Singleton
public interface AppComponent {

}
