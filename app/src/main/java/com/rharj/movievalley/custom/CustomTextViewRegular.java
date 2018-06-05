package com.rharj.movievalley.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.rharj.movievalley.cache.FontCache;

public class CustomTextViewRegular extends android.support.v7.widget.AppCompatTextView {

    public CustomTextViewRegular(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public CustomTextViewRegular(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public CustomTextViewRegular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("font/Montserrat-Regular.ttf", context);
        setTypeface(customFont);
    }
}
