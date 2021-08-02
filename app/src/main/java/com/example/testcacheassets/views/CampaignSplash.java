package com.example.testcacheassets.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.testcacheassets.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CampaignSplash extends View {

    public static List<String> listKeys = Arrays.asList(
            "img_campaign_background",
            "img_campaign_surrounding",
            "img_campaign_header",
            "img_campaign_footer"
            //add more component here
    );

    private CampaignSplash(Context context) {
        super(context);
    }

    public static View init(Context context) {
        View view = View.inflate(context, R.layout.campaign_splash_screen, null);

        SplashImage footer = view.findViewById(R.id.img_campaign_footer);
        SplashImage header = view.findViewById(R.id.img_campaign_header);

        header.fixTo(SplashImage.FixedPosition.TOP);
        footer.fixTo(SplashImage.FixedPosition.BOTTOM);
        return view;
    }

    public static View init(Context context, Map<String, Bitmap> mapResource) {
        View view = View.inflate(context, R.layout.campaign_splash_screen, null);

        //mapping
        Map<String, Integer> mapId = new HashMap<>();
        mapId.put("img_campaign_background", R.id.img_campaign_background);
        mapId.put("img_campaign_surrounding", R.id.img_campaign_surrounding);
        mapId.put("img_campaign_header", R.id.img_campaign_header);
        mapId.put("img_campaign_footer", R.id.img_campaign_footer);
        //add more component here

        for (String key : CampaignSplash.listKeys) {
            Integer componentId = mapId.get(key);
            Bitmap bitmap = mapResource.get(key);

            if (bitmap == null || componentId == null){
                continue;
            }

            ImageView imageView = view.findViewById(componentId);
            imageView.setImageBitmap(bitmap);
        }

        //custom base on what dicussed with designer
        ((SplashImage)view.findViewById(R.id.img_campaign_footer)).fixTo(SplashImage.FixedPosition.BOTTOM);
        ((SplashImage)view.findViewById(R.id.img_campaign_surrounding)).fixTo(SplashImage.FixedPosition.TOP);

        return view;
    }
}
