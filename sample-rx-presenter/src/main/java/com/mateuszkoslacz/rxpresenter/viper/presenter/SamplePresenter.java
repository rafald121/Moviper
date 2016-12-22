package com.mateuszkoslacz.rxpresenter.viper.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter;
import com.mateuszkoslacz.rxpresenter.viper.contract.SampleContract;
import com.mateuszkoslacz.rxpresenter.viper.interactor.SampleInteractor;
import com.mateuszkoslacz.rxpresenter.viper.routing.SampleRouting;


import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class SamplePresenter
        extends BaseRxPresenter<SampleContract.View,
                                SampleContract.Interactor,
                                SampleContract.Routing>
        implements SampleContract.Presenter {

    @NonNull
    @Override
    public SampleContract.Routing createRouting() {
        return new SampleRouting();
    }

    @NonNull
    @Override
    public SampleContract.Interactor createInteractor() {
        return new SampleInteractor();
    }

    @Override
    public void onViewCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) return;

        addSubscription(Observable.interval(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        number -> getView().showNumber(number),
                        Throwable::printStackTrace
                ));
    }
}