package com.arabiait.di.Service;

import com.arabiait.di.Model.FlowerResponse;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Ahmed El-Mahdi on 11/8/2017.
 */

public interface FlowerService {
    @GET("/feeds/flowers.json")
    Observable<List<FlowerResponse>> getFlowers();
}
