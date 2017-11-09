package com.arabiait.di.DependancyInjection.Component;

import com.arabiait.di.DependancyInjection.Module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Ahmed El-Mahdi on 11/8/2017.
 */
@Singleton
@Component(modules = NetworkModule.class)
public interface NetworkComponent {
    Retrofit retrofit();
}
