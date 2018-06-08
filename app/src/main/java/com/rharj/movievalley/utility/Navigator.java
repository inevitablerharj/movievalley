package com.rharj.movievalley.utility;

import android.app.Activity;
import android.content.Intent;

import com.rharj.movievalley.activity.ActivityMovieDetails;

public class Navigator {

    private final Activity activity;

    public Navigator(Activity activity){
        this.activity = activity;
    }

    public void navigateToMovieDetailsActivity(){
        Intent intent = new Intent(activity, ActivityMovieDetails.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(0,0);
    }
}
