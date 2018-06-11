package com.rharj.movievalley.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.rharj.movievalley.R;
import com.rharj.movievalley.model.MovieListModel;
import com.rharj.movievalley.utility.Navigator;
import com.rharj.movievalley.utility.Utils;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ActivityMovieDetails extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    ActionBar actionBar;
    ImageView cover_image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_movie_details);
        supportPostponeEnterTransition();
        initializeControls();
    }

    private void initializeControls(){

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        Utils.dynamicToolBarColoring(ActivityMovieDetails.this,collapsingToolbarLayout);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle("Zootopia");
                    isShow = true;
                } else if(isShow) {
                    collapsingToolbarLayout.setTitle(" ");
                    isShow = false;
                }
            }
        });

        Bundle extras = getIntent().getExtras();
        MovieListModel movieListModel = (MovieListModel) extras.getSerializable(Navigator.EXTRA_ANIMAL_ITEM);

        cover_image = (ImageView) findViewById(R.id.cover_image);

        int imageUrl = movieListModel.getImageUrl();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String imageTransitionName = extras.getString(Navigator.EXTRA_ANIMAL_IMAGE_TRANSITION_NAME);
            cover_image.setTransitionName(imageTransitionName);
        }

        Picasso.with(this).load(imageUrl).noFade().into(cover_image, new Callback() {
                    @Override
                    public void onSuccess() {
                        supportStartPostponedEnterTransition();
                    }

                    @Override
                    public void onError() {
                        supportStartPostponedEnterTransition();
                    }
                });
    }
}
