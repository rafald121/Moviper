package com.mateuszkoslacz.moviper.base.mateuszkoslacz.moviper.base.view.fragment.autoinject.passive.butterknife;

import android.view.View;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

import butterknife.ButterKnife;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperButterKnifeLceViewStatePassiveFragment
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                ViewStateType extends ViewState<ViewType>>
        extends ViperLceViewStateAiPassiveFragment<ContentView, Model, ViewType, ViewStateType>
        implements MvpLceView<Model>, ViperView {

    @Override
    protected void injectViews(View view) {
        super.injectViews(view);
        ButterKnife.bind(this, view);
    }
}
