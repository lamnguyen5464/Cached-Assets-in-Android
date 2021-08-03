package com.example.testcacheassets.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
        BOTTOM,
        MID
    }

    private void scaleImageVertical(float ratio) {
        this.setScaleType(ImageView.ScaleType.MATRIX);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        final float statusBarHeight = BitmapUtils.pxFromDp(getContext(), 30);
        final int SCREEN_WIDTH = metrics.widthPixels;
        final int SCREEN_HEIGHT = (int) (metrics.heightPixels + statusBarHeight);

        Drawable drawable = getDrawable();
        if (drawable == null) return;
        final int drawableWidth = drawable.getIntrinsicWidth();
        final int drawableHeight = drawable.getIntrinsicHeight();

        final float drawableRatio = (float) drawableWidth / drawableHeight;

        //ratio of scaleWidth
        final float scaleWidth = (float) SCREEN_WIDTH / drawableWidth;

        //keep the ratio of image
        final float realHeight = SCREEN_WIDTH / drawableRatio;

        Matrix matrix = new Matrix();
        matrix.setScale(scaleWidth, realHeight / drawableHeight);   //scale drawble to fit imageview

        matrix.postTranslate(
                0,
                (ratio) *  Math.abs(SCREEN_HEIGHT - realHeight)
        );   //translate to fix top (bottom)
        setImageMatrix(matrix);
    }

    public void fixTo(FixedPosition fixedPosition) {
        switch (fixedPosition) {
            case TOP:
                scaleImageVertical(0);
                break;
            case BOTTOM:
                scaleImageVertical(-1);
                break;
            case MID:
                scaleImageVertical((float)-0.5);
                break;
            default:
        }
    }
}
