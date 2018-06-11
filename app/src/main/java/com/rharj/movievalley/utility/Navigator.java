package com.rharj.movievalley.utility;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.widget.ImageView;

import com.rharj.movievalley.activity.ActivityMovieDetails;
import com.rharj.movievalley.model.MovieListModel;

public class Navigator {

    private final Activity activity;
    public static final String EXTRA_ANIMAL_ITEM = "movie_image_url";
    public static  final String EXTRA_ANIMAL_IMAGE_TRANSITION_NAME = "movie_image_transition_name";

    public Navigator(Activity activity){
        this.activity = activity;
    }

    public void navigateToMovieDetailsActivity(MovieListModel movieListModel, ImageView imageView){

        Intent intent = new Intent(activity, ActivityMovieDetails.class);
        intent.putExtra(EXTRA_ANIMAL_ITEM, movieListModel);
        intent.putExtra(EXTRA_ANIMAL_IMAGE_TRANSITION_NAME, ViewCompat.getTransitionName(imageView));

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity,
                imageView,
                ViewCompat.getTransitionName(imageView));

        activity.startActivity(intent,options.toBundle());
        activity.overridePendingTransition(0,0);
    }
}
