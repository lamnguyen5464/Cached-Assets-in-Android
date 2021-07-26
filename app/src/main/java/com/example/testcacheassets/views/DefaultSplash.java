package com.example.testcacheassets.views;

import android.content.Context;
import android.view.View;


import com.example.testcacheassets.R;

public class DefaultSplash extends View {
    private DefaultSplash(Context context) {
        super(context);
    }

    public static View init(Context context) {
        return View.inflate(context, R.layout.default_splash_screen, null);
    }
}
