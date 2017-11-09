package com.arabiait.di.View;

import com.arabiait.di.Model.FlowerResponse;

import java.util.List;

import rx.Observable;

/**
 * Created by Ahmed El-Mahdi on 11/8/2017.
 */

public interface FlowerView  {
    void onCompleted();

    void onError(String message);

    void onFlowers(List<FlowerResponse> flowerResponses);

    Observable<List<FlowerResponse>> getFlowers();
}
