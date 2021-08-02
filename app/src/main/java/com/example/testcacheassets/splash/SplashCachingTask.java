package com.example.testcacheassets.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.testcacheassets.utils.BitmapUtils;
import com.example.testcacheassets.utils.SafeJSONObject;
import com.example.testcacheassets.views.CampaignSplash;

import java.util.concurrent.ExecutionException;


public class SplashCachingTask extends AsyncTask<Void, Void, SafeJSONObject> {
    private Context context;
    private final String REMOTE_KEY = "config_campaign_splash";

    public SplashCachingTask(Context context) {
        this.context = context;
    }

    private SafeJSONObject fetchNewConfig() {
//        RemoteConfigHelper remoteConfigHelper = new RemoteConfigHelper(context, RemoteConfigModule.SERVICE_NAME);
//        try {
//            Tasks.await(remoteConfigHelper.fetchAndActivate());
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String configString = remoteConfigHelper.getValueForKey(FirebaseApp.DEFAULT_APP_NAME, REMOTE_KEY);

        String tmp = "{\n" +
                "  \"img_campaign_background\": \"https://cdn.mservice.com.vn/app/img/splash/img_campaign_background.png\",\n" +
                "  \"img_campaign_surrounding\": \"https://cdn.mservice.com.vn/app/img/splash/img_campaign_surrounding.png\",\n" +
                "  \"img_campaign_header\": \"https://cdn.mservice.com.vn/app/img/splash/img_campaign_header.png\",\n" +
                "  \"img_campaign_footer\": \"https://cdn.mservice.com.vn/app/img/splash/img_campaign_footer.png\",\n" +
                "  \"vers\": \"3\",\n" +
                "  \"status\": \"off\"\n" +
                "}";
        return SafeJSONObject.parseSafe(tmp);
    }

    private boolean isNewConfig(SafeJSONObject newConfig) {
        if (newConfig == null) return false;
        SafeJSONObject oldConfig = SplashConfigRepo.getConfigLocal(context);
        return (oldConfig == null || !newConfig.getStringSafely("vers").equals(oldConfig.getStringSafely("vers")));
    }

    @Override
    protected SafeJSONObject doInBackground(Void... voids) {
        SafeJSONObject param = fetchNewConfig();
        Log.d("@@@",param.toString());
        if (!isNewConfig(param)) return null;
        String internalFilePath = "";
        for (String key : CampaignSplash.listKeys) {
            String url = param.getStringSafely(key);
            if (url.isEmpty()) continue;
            Bitmap bitmap = BitmapUtils.loadBitmap(url);
            internalFilePath = BitmapUtils.saveToStorage(context, bitmap, BitmapUtils.getImageName(url));
        }
        param.putStringSafely("internalFilePath", internalFilePath);
        return param;
    }

    @Override
    protected void onPostExecute(SafeJSONObject param) {
        super.onPostExecute(param);
        if (param != null) {
            SplashConfigRepo.storeConfigLocal(context, param);
            Toast.makeText(context, "Finish caching " + param.toString(), Toast.LENGTH_LONG).show();
        }else{
        }
    }
}
