package com.rharj.movievalley.utility;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.graphics.Palette;

import com.rharj.movievalley.R;

public class Utils {

    public static void dynamicToolBarColoring(Context context, final CollapsingToolbarLayout
            collapsingToolbarLayout){

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.zootopia_full);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor
                        (R.attr.colorPrimary));
                collapsingToolbarLayout.setStatusBarScrimColor(palette.getMutedColor
                        (R.attr.colorPrimaryDark));
            }
        });
    }
}
