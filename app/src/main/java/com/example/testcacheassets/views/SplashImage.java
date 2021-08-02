package com.example.testcacheassets.views;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.testcacheassets.utils.BitmapUtils;

public class SplashImage extends androidx.appcompat.widget.AppCompatImageView {
    public SplashImage(@NonNull Context context) {
        super(context);
    }

    public SplashImage(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SplashImage(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public enum FixedPosition {
        TOP,
        BOTTOM
    }

    private void scaleImageVertical(boolean isFixedTop) {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int SCREEN_WIDTH = metrics.widthPixels;
        int SCREEN_HEIGHT = metrics.heightPixels;


        Drawable drawable = getDrawable();
        if (drawable == null) return;
        final int drawableWidth = drawable.getIntrinsicWidth();
        final int drawableHeight = drawable.getIntrinsicHeight();

        final float drawableRatio = (float) drawableWidth / drawableHeight;

        //ratio of scaleWidth
        final float scaleWidth = (float) SCREEN_WIDTH / drawableWidth;

        //keep the ratio of image
        final float realHeight = SCREEN_WIDTH / drawableRatio;

        Matrix matrix = getImageMatrix();
        matrix.setScale(scaleWidth, realHeight / drawableHeight);   //scale drawble to fit imageview
        matrix.preTranslate(
                0,
                (isFixedTop ? 0 : -1) *  (realHeight - SCREEN_HEIGHT)
        );   //translate to fix top (bottom)

        this.setScaleType(ImageView.ScaleType.MATRIX);
        setImageMatrix(matrix);
    }

    public void fixTo(FixedPosition fixedPosition) {
        switch (fixedPosition) {
            case TOP:
                scaleImageVertical(true);
                break;
            case BOTTOM:
                scaleImageVertical(false);
                break;
            default:
        }
    }
}
