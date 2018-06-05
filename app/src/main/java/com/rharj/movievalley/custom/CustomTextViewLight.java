package com.rharj.movievalley.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.rharj.movievalley.cache.FontCache;

public class CustomTextViewLight extends android.support.v7.widget.AppCompatTextView {

    public CustomTextViewLight(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public CustomTextViewLight(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public CustomTextViewLight(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("font/Montserrat-Light.ttf", context);
        setTypeface(customFont);
    }
}
