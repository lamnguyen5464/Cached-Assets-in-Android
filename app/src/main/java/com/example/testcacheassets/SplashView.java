package com.example.testcacheassets;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.testcacheassets.splash.SplashCachingTask;
import com.example.testcacheassets.splash.SplashLoaderTask;
import com.example.testcacheassets.utils.SafeJSONObject;
import com.example.testcacheassets.views.DefaultSplash;

public class SplashView extends Dialog {
    public SplashView(@NonNull Context context) {
        super(context, R.style.SplashScreen_SplashTheme);
    }

    public SplashView(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected SplashView(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public void show() {
        setContentView(DefaultSplash.init(getContext()));
        super.show();


        //load loaded Campaign
        new SplashLoaderTask(getContext(), this).execute();
    }
}
