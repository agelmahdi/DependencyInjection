package com.arabiait.di.Base;

import com.arabiait.di.Model.FlowerResponse;
import com.arabiait.di.View.FlowerView;

import java.util.List;

import rx.Observer;

/**
 * Created by Ahmed El-Mahdi on 11/8/2017.
 */

public class FlowerPresenter extends BasePresenter implements Observer<List<FlowerResponse>>{
    private FlowerView mFlowerView;

    public FlowerPresenter(FlowerView flowerView) {
        this.mFlowerView = flowerView;
    }

    @Override
    public void onCompleted() {
        mFlowerView.onCompleted();
    }

    @Override
    public void onError(Throwable e) {

        mFlowerView.onError(e.getMessage());
    }

    @Override
    public void onNext(List<FlowerResponse> flowerResponses) {

        mFlowerView.onFlowers(flowerResponses);
    }

    public void fetchFlowers() {
        unSubscribeAll();
        subscribe(mFlowerView.getFlowers(),FlowerPresenter.this);
    }
}
