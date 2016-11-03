package com.mateuszkoslacz.moviper.sample.viper.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.mateuszkoslacz.moviper.sample.R;
import com.mateuszkoslacz.moviper.sample.viper.contract.FullscreenPhotoContract;
import com.mateuszkoslacz.moviper.sample.viper.presenter.FullscreenPhotoPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FullscreenPhotoActivity
        // you can change base class to any Mosby Activity, ie. MvpLceActivity, MvpViewStateActivity, etc.
        extends MvpActivity<FullscreenPhotoContract.View, FullscreenPhotoContract.Presenter>
        implements FullscreenPhotoContract.View {

    public static final String PHOTO_EXTRA = "PHOTO_EXTRA";

    @BindView(R.id.photo)
    ImageView mPhotoImageView;

    public static void start(Activity activity, String avatarUrl, ImageView avatarImageView) {
        Intent starter = new Intent(activity, FullscreenPhotoActivity.class);
        starter.putExtra(PHOTO_EXTRA, avatarUrl);

        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                .makeSceneTransitionAnimation(activity,
                        avatarImageView,
                        activity.getString(R.string.avatar_transition));
        activity.startActivity(starter, optionsCompat.toBundle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_photo);
        ButterKnife.bind(this);

        loadPhoto(getPresenter().getPhotoUrlIntentFromUserDetailsActivity());
    }

    private void loadPhoto(String photoUrlFromIntent) {
        if (!photoUrlFromIntent.equals(""))
            Glide.with(this)
                    .load(photoUrlFromIntent)
                    .into(mPhotoImageView);
    }

    @NonNull
    @Override
    public FullscreenPhotoContract.Presenter createPresenter() {
        return new FullscreenPhotoPresenter(this);
    }
}