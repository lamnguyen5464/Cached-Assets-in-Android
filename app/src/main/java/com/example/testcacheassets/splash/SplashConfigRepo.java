package com.example.testcacheassets.splash;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.testcacheassets.utils.SafeJSONObject;

public class SplashConfigRepo {
    private static final String SPLASH_CONFIG_KEY = "SPLASH_CONFIG_KEY";
    private static final String INTERNAL_STORAGE = "INTERNAL_STORAGE";

    public static void setConfigLocal(Context context, SafeJSONObject params) {
        Log.d("@@@", "setConfigLocal ");
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(INTERNAL_STORAGE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SPLASH_CONFIG_KEY, params.toString());
        editor.commit();
    }

    public static SafeJSONObject getConfigLocal(Context context) {
        Log.d("@@@", "getConfigLocal ");
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(INTERNAL_STORAGE, Context.MODE_PRIVATE);
        String stringConfig = sharedPreferences.getString(SPLASH_CONFIG_KEY, "");
        SafeJSONObject config = SafeJSONObject.parseSafe(stringConfig);
        return config;
    }
}
