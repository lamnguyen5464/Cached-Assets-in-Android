package com.example.testcacheassets.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BitmapUtils {

    public static Bitmap loadBitmap(String url) {
        Log.d("@@@", "start downloading..." + url);
        Bitmap bitmap = null;
        InputStream in = null;
        try {
            in = new java.net.URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(in);
        } catch (IOException e) {
            Log.d("@@@", "Could not load Bitmap from: " + url);
        } finally {
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.d("@@@", "finish downloading");
        return bitmap;
    }

    public static String saveToStorage(Context context, Bitmap bitmapImage, String fileName) {
        Log.d("@@@ ", "start cache to storage...");
        ContextWrapper cw = new ContextWrapper(context);
        File directory = cw.getDir("imageDirect", Context.MODE_PRIVATE);
        // Create imageDir
        File myPath = new File(directory, fileName);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(myPath);
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Log.d("@@@ ", "finish caching for path: " + directory.getAbsolutePath());

        return directory.getAbsolutePath();
    }

    public static Bitmap loadFromStorage(String path, String fileName) {
        Log.d("@@@ ", "start loading from storage");
        Bitmap res = null;
        try {
            File f = new File(path, fileName);
            res = BitmapFactory.decodeStream(new FileInputStream(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Log.d("@@@ ", "finish loading");
        return res;
    }

    public static String getImageName(String url) {
        String res = "";
        int firstIndex = url.length() - 1;
        while (url.charAt(firstIndex) != '/' && firstIndex > 0) {
            firstIndex--;
        }

        for (int i = firstIndex + 1; i < url.length(); i++) {
            res += url.charAt(i);
        }
        return res;
    }

    public static float dpFromPx(final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    public static float pxFromDp(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

}
