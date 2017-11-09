package com.arabiait.di.DependancyInjection.Component;

import com.arabiait.di.DependancyInjection.Module.ApiModule;
import com.arabiait.di.DependancyInjection.Module.NetworkModule;
import com.arabiait.di.DependancyInjection.Scope.AppScope;
import com.arabiait.di.MainActivity;

import dagger.Component;

/**
 * Created by Ahmed El-Mahdi on 11/8/2017.
 */
@AppScope
@Component(modules = ApiModule.class,dependencies = NetworkComponent.class)
public interface ApiComponent {
    void inject(MainActivity mainActivity);
}
