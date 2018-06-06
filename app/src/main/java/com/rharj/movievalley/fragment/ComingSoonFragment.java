package com.rharj.movievalley.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rharj.movievalley.R;
import com.rharj.movievalley.adapter.ComingSoonAdapter;
import com.rharj.movievalley.model.ComingSoonModel;

import java.util.ArrayList;
import java.util.List;

public class ComingSoonFragment extends Fragment {

    RecyclerView movie_list_coming_soon;
    ComingSoonAdapter comingSoonAdapter;
    List<ComingSoonModel> comingSoonModelList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = prepareViews(inflater, container);
        return rootView;

    }

    private View prepareViews(LayoutInflater inflater, ViewGroup container) {
        final View mainView = inflater.inflate(R.layout.layout_coming_soon_movie, container,
                false);

        movie_list_coming_soon = (RecyclerView) mainView.findViewById(R.id.movie_list_coming_soon);
        comingSoonAdapter = new ComingSoonAdapter(comingSoonModelList,getContext());
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getActivity(), 3);
        movie_list_coming_soon.setLayoutManager(linearLayoutManager);
        movie_list_coming_soon.setItemAnimator(new DefaultItemAnimator());
        movie_list_coming_soon.setNestedScrollingEnabled(false);
        movie_list_coming_soon.setAdapter(comingSoonAdapter);
        movie_list_coming_soon.hasFixedSize();

        prepareMovieData();
        return mainView;
    }

    private void prepareMovieData() {
        ComingSoonModel comingSoonModel = new ComingSoonModel(R.drawable.shape_of_water,
                "Avengers","Animation | Action | Drama");
        comingSoonModelList.add(comingSoonModel);

        comingSoonModel = new ComingSoonModel(R.drawable.shape_of_water,
                "Black Panther","Animation | Action | Drama");
        comingSoonModelList.add(comingSoonModel);

        comingSoonModel = new ComingSoonModel(R.drawable.shape_of_water,
                "Dark Waters","Animation | Action | Drama");
        comingSoonModelList.add(comingSoonModel);

        comingSoonModel = new ComingSoonModel(R.drawable.shape_of_water,
                "Shape Of Water","Animation | Action | Drama");
        comingSoonModelList.add(comingSoonModel);

        comingSoonModel = new ComingSoonModel(R.drawable.shape_of_water,
                "Tomb Raider","Animation | Action | Drama");
        comingSoonModelList.add(comingSoonModel);

        comingSoonModel = new ComingSoonModel(R.drawable.shape_of_water,
                "Shape Of Water","Animation | Action | Drama");
        comingSoonModelList.add(comingSoonModel);

        comingSoonModel = new ComingSoonModel(R.drawable.shape_of_water,
                "The Prestige","Animation | Action | Drama");
        comingSoonModelList.add(comingSoonModel);

        comingSoonModel = new ComingSoonModel(R.drawable.shape_of_water,
                "Infinity War","Animation | Action | Drama");
        comingSoonModelList.add(comingSoonModel);

        comingSoonModel = new ComingSoonModel(R.drawable.shape_of_water,
                "Iron Man","Animation | Action | Drama");
        comingSoonModelList.add(comingSoonModel);

        comingSoonAdapter.notifyDataSetChanged();
    }
}
