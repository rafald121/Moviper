package com.mateuszkoslacz.moviper.base.view.fragment.autoinject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.base.view.fragment.mvp.MvpLceViewStateAiFragment;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperLceViewStateAiFragment
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                Presenter extends MvpPresenter<ViewType>,
                ViewStateType extends ViewState<ViewType>>
        extends MvpLceViewStateAiFragment<ContentView, Model, ViewType, Presenter>
        implements ViperLceView<Model> {

    @Override
    public ViewStateType getViewState() {
        return (ViewStateType) super.getViewState();
    }

    @NonNull
    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public Bundle getArgs() {
        return getArguments();
    }
}
