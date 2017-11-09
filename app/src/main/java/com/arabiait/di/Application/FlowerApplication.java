package com.arabiait.di.Application;

import android.app.Application;

import com.arabiait.di.Constant.Constant;
import com.arabiait.di.DependancyInjection.Component.ApiComponent;
import com.arabiait.di.DependancyInjection.Component.DaggerApiComponent;
import com.arabiait.di.DependancyInjection.Component.DaggerNetworkComponent;
import com.arabiait.di.DependancyInjection.Component.NetworkComponent;
import com.arabiait.di.DependancyInjection.Module.NetworkModule;


/**
 * Created by Ahmed El-Mahdi on 11/8/2017.
 */

public class FlowerApplication extends Application {

    ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        resolveDependancy();

        super.onCreate();
    }

    private void resolveDependancy() {
                 mApiComponent = DaggerApiComponent.builder()
                .networkComponent(getNetworkComponent())
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constant.BASE_URL))
                .build();
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }

}
