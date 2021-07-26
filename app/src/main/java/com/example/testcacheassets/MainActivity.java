package com.example.testcacheassets;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.testcacheassets.splash.SplashCachingTask;
import com.example.testcacheassets.utils.SafeJSONObject;

import static android.os.FileUtils.copy;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SplashView splashView = new SplashView(this);
        splashView.show();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splashView.dismiss();
                setContentView(R.layout.activity_main);
                findViewById(R.id.set).setOnClickListener(MainActivity.this::onClick);
                findViewById(R.id.get).setOnClickListener(MainActivity.this::onClick);
            }
        }, 3000);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.set:
                SafeJSONObject object = SafeJSONObject.parseSafe("{\n" +
                        "}");
                new SplashCachingTask(getBaseContext()).execute(object);
                break;
            case R.id.get:
                SafeJSONObject obj = SafeJSONObject.parseSafe("{\n" +
                        "  \"image_background\": \"https://cdn.mservice.com.vn/app/img/platform/img_mmct_background.png\",\n" +
                        "  \"image_header\": \"https://cdn.mservice.com.vn/app/img/platform/img_mmct_header.png\",\n" +
                        "  \"image_footer\": \"https://cdn.mservice.com.vn/app/img/platform/img_mmct_footer.png\"\n" +
                        "}");

                new SplashCachingTask(getBaseContext()).execute(obj);
                break;
            default:
        }
    }
}