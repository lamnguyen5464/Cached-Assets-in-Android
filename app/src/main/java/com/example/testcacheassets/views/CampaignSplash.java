package com.example.testcacheassets.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.example.testcacheassets.R;
import com.example.testcacheassets.utils.SafeJSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CampaignSplash extends View {

    public static List<String> listKeys = Arrays.asList(
            "image_header",
            "image_footer",
            "image_background"
            //add more component here
    );

    private CampaignSplash(Context context) {
        super(context);
    }

    public static View init(Context context, Map<String, Bitmap> mapResource){
        View view = View.inflate(context, R.layout.campaign_splash_screen, null);
        Map<String, Integer> map = new HashMap<>();
        map.put("image_header", R.id.image_header);
        map.put("image_footer", R.id.image_footer);
        map.put("image_background", R.id.image_background);
        //add more component here

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer componentId = entry.getValue();
            ImageView imageView = view.findViewById(componentId);
            Bitmap bitmap = mapResource.get(key);
            imageView.setImageBitmap(bitmap);
        }
        return view;
    }
}
