package com.example.testcacheassets.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.testcacheassets.SplashView;
import com.example.testcacheassets.utils.BitmapUtils;
import com.example.testcacheassets.utils.SafeJSONObject;
import com.example.testcacheassets.views.CampaignSplash;

import java.util.HashMap;
import java.util.Map;

public class SplashLoaderTask extends AsyncTask<Void, Void, Map<String, Bitmap>> {
    private Context context;
    private SplashView splashView;

    public SplashLoaderTask(Context context, SplashView splashView) {
        this.context = context;
        this.splashView = splashView;
    }

    @Override
    protected Map<String, Bitmap> doInBackground(Void... voids) {
        Map<String, Bitmap> map = new HashMap<>();
        SafeJSONObject configData = SplashConfigRepo.getConfigLocal(context);
        if (configData == null || !configData.getStringSafely("status").equals("on")) {
            return null;
        }

        String path = configData.getStringSafely("internalFilePath");

        for (String key : CampaignSplash.listKeys) {
            String url = configData.getStringSafely(key);
            if (url.isEmpty()) continue;
            Bitmap loadedBitmap = BitmapUtils.loadFromStorage(path, BitmapUtils.getImageName(url));
            map.put(key, loadedBitmap);
        }
        return map;
    }

    @Override
    protected void onPostExecute(Map<String, Bitmap> map) {
        super.onPostExecute(map);
        if (map != null && map.size() != 0) {
            changeSplashView(map);
        }
    }

    private void changeSplashView(Map<String, Bitmap> map) {
        this.splashView.setContentView(CampaignSplash.init(context, map));
    }
}
