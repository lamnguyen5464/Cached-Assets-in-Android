package com.example.testcacheassets.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.testcacheassets.utils.BitmapUtils;
import com.example.testcacheassets.utils.SafeJSONObject;
import com.example.testcacheassets.views.CampaignSplash;

public class SplashCachingTask extends AsyncTask<SafeJSONObject, Void, SafeJSONObject> {
    private Context context;

    public SplashCachingTask(Context context) {
        this.context = context;
    }

    @Override
    protected SafeJSONObject doInBackground(SafeJSONObject... params) {
        SafeJSONObject param = null;
        if (params != null || params.length > 0) {
            param = params[0];

            String internalFilePath = "";

            for (String key : CampaignSplash.listKeys) {
                String url = param.getStringSafely(key);
                if (url.isEmpty()) continue;
                Bitmap bitmap = BitmapUtils.loadBitmap(url);
                internalFilePath = BitmapUtils.saveToStorage(context, bitmap, BitmapUtils.getImageName(url));
            }
            param.putStringSafely("internalFilePath", internalFilePath);
        }
        return param;
    }

    @Override
    protected void onPostExecute(SafeJSONObject param) {
        super.onPostExecute(param);
        if (param != null) {
            SplashConfigRepo.setConfigLocal(context, param);
            Toast.makeText(context, "Finish caching " + param.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
