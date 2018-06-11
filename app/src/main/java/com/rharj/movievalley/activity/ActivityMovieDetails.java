package com.rharj.movievalley.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.rharj.movievalley.R;
import com.rharj.movievalley.adapter.ComingSoonAdapter;
import com.rharj.movievalley.adapter.OtherMovieShowingAdapter;
import com.rharj.movievalley.model.ComingSoonModel;
import com.rharj.movievalley.model.MovieListModel;
import com.rharj.movievalley.utility.Navigator;
import com.rharj.movievalley.utility.RecyclerViewMargin;
import com.rharj.movievalley.utility.Utils;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ActivityMovieDetails extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbarLayout;
    RecyclerView other_movies;
    private OtherMovieShowingAdapter otherMovieShowingAdapter;
    List<ComingSoonModel> comingSoonModelList = new ArrayList<>();
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

        other_movies = (RecyclerView) findViewById(R.id.other_movies);
        otherMovieShowingAdapter = new OtherMovieShowingAdapter(comingSoonModelList,ActivityMovieDetails.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ActivityMovieDetails.this,
                LinearLayoutManager.HORIZONTAL,false);
        other_movies.setLayoutManager(linearLayoutManager);
        RecyclerViewMargin decoration = new RecyclerViewMargin(15, 10);
        other_movies.addItemDecoration(decoration);
        other_movies.setNestedScrollingEnabled(false);
        other_movies.setAdapter(otherMovieShowingAdapter);
        other_movies.hasFixedSize();

        prepareMovieData();
    }

    private void prepareMovieData() {
        ComingSoonModel comingSoonModel = new ComingSoonModel(R.drawable.zootopia,
                "Avengers","Animation | Action");
        comingSoonModelList.add(comingSoonModel);

        comingSoonModel = new ComingSoonModel(R.drawable.zootopia,
                "Black Panther","Animation | Action");
        comingSoonModelList.add(comingSoonModel);

        comingSoonModel = new ComingSoonModel(R.drawable.zootopia,
                "Dark Waters","Animation | Action");
        comingSoonModelList.add(comingSoonModel);

        comingSoonModel = new ComingSoonModel(R.drawable.zootopia,
                "Shape Of Water","Animation | Action");
        comingSoonModelList.add(comingSoonModel);

        comingSoonModel = new ComingSoonModel(R.drawable.zootopia,
                "Tomb Raider","Animation | Action");
        comingSoonModelList.add(comingSoonModel);

        comingSoonModel = new ComingSoonModel(R.drawable.zootopia,
                "Shape Of Water","Animation | Action");
        comingSoonModelList.add(comingSoonModel);

        comingSoonModel = new ComingSoonModel(R.drawable.zootopia,
                "The Prestige","Animation | Action");
        comingSoonModelList.add(comingSoonModel);

        comingSoonModel = new ComingSoonModel(R.drawable.zootopia,
                "Infinity War","Animation | Action");
        comingSoonModelList.add(comingSoonModel);

        comingSoonModel = new ComingSoonModel(R.drawable.zootopia,
                "Iron Man","Animation | Action");
        comingSoonModelList.add(comingSoonModel);

        otherMovieShowingAdapter.notifyDataSetChanged();
    }
}
