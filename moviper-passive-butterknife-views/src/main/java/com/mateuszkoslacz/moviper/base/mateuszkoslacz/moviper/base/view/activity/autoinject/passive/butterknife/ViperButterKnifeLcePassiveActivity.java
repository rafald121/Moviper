package com.mateuszkoslacz.moviper.base.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.butterknife;

import android.view.View;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import butterknife.ButterKnife;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperButterKnifeLcePassiveActivity
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>>
        extends ViperLceAiPassiveActivity<ContentView, Model, ViewType>
        implements MvpLceView<Model>, ViperView {

    @Override
    protected void injectViews() {
        super.injectViews();
        ButterKnife.bind(this);
    }
}
