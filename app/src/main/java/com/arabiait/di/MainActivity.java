package com.arabiait.di;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arabiait.di.Application.FlowerApplication;
import com.arabiait.di.Base.FlowerPresenter;
import com.arabiait.di.Model.FlowerResponse;
import com.arabiait.di.Service.FlowerService;
import com.arabiait.di.View.FlowerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;

public class MainActivity extends AppCompatActivity implements FlowerView {

    @Inject
    FlowerService flowerService;

    private FlowerPresenter mFlowerPresenter;

    private FlowerAdapter mFlowerAdapter;

    private ProgressBar mProgressBar;
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resolveDependancy();

        ButterKnife.bind(MainActivity.this);
        configViews();

        mFlowerPresenter = new FlowerPresenter(MainActivity.this);
        mFlowerPresenter.onCreate();
    }

    private void resolveDependancy() {
        ((FlowerApplication)getApplication() )
                .getApiComponent()
                .inject(MainActivity.this);
    }

    private void configViews() {
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFlowerAdapter = new FlowerAdapter(new ArrayList<FlowerResponse>());
        mRecyclerView.setAdapter(mFlowerAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mFlowerPresenter.onResume();
        mFlowerPresenter.fetchFlowers();
        mProgressBar = new ProgressBar(MainActivity.this);
        mProgressBar.setIndeterminate(true);

    }

    @Override
    public void onCompleted() {
        mProgressBar.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(),"Flower Done!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        mProgressBar.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFlowers(List<FlowerResponse> flowerResponses) {

        mFlowerAdapter.addFlowers(flowerResponses);
    }

    @Override
    public Observable<List<FlowerResponse>> getFlowers() {
        return flowerService.getFlowers();
    }
}
