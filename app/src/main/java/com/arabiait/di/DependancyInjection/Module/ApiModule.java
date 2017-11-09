package com.arabiait.di.DependancyInjection.Module;

import com.arabiait.di.DependancyInjection.Scope.AppScope;
import com.arabiait.di.Service.FlowerService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Ahmed El-Mahdi on 11/8/2017.
 */
@Module
public class ApiModule {
    @Provides
    @AppScope
    FlowerService provideFlowerService(Retrofit retrofit){
        return retrofit.create(FlowerService.class);
    }
}
