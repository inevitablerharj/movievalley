package com.rharj.movievalley.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.rharj.movievalley.cache.FontCache;

public class CustomExapndableTextView extends at.blogc.android.views.ExpandableTextView {

    public CustomExapndableTextView(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public CustomExapndableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public CustomExapndableTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("font/Montserrat-Light.ttf", context);
        setTypeface(customFont);
    }
}
