package com.example.testcacheassets;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.example.testcacheassets.splash.SplashCachingTask;
import com.example.testcacheassets.splash.SplashLoaderTask;
import com.example.testcacheassets.views.DefaultSplash;

public class SplashView extends Dialog {
    public SplashView(@NonNull Context context) {
        super(context, R.style.SplashScreen_SplashTheme);
    }

    @Override
    public void show() {
        showDefaultSplash();
        showCampaignSplash();
    }

    private void showDefaultSplash(){
        setContentView(DefaultSplash.init(getContext()));
        super.show();
    }

    private void showCampaignSplash(){
        new SplashLoaderTask(getContext(), this).execute();
        new SplashCachingTask(getContext()).execute();  //load and cache new config
    }
}
