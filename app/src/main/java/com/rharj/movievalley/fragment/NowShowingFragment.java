package com.rharj.movievalley.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rharj.movievalley.R;
import com.rharj.movievalley.adapter.MovieListAdapter;
import com.rharj.movievalley.model.MovieListModel;

import java.util.ArrayList;
import java.util.List;

public class NowShowingFragment extends Fragment {

    RecyclerView movie_list;
    MovieListAdapter movieListAdapter;
    List<MovieListModel> movieListModelList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = prepareViews(inflater, container);
        return rootView;

    }

    private View prepareViews(LayoutInflater inflater, ViewGroup container) {
        final View mainView = inflater.inflate(R.layout.layout_now_showing_movie, container,
                false);

        movie_list = (RecyclerView) mainView.findViewById(R.id.movie_list);
        movieListAdapter = new MovieListAdapter(movieListModelList,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,false);
        movie_list.setLayoutManager(linearLayoutManager);
        movie_list.setItemAnimator(new DefaultItemAnimator());
        movie_list.setNestedScrollingEnabled(false);
        movie_list.setAdapter(movieListAdapter);
        movie_list.hasFixedSize();

        prepareMovieData();

        return mainView;
    }


    private void prepareMovieData() {

        MovieListModel movieListModel = new MovieListModel("Zootopia","Animation | Action | Adventure",
                "8.2","EN","In a city of animals, a rockie bunny cop and a cynical con artist fox must work together to uncover a...",
                "","107 min","17 June 2016(USA)",R.drawable.zootopia);
        movieListModelList.add(movieListModel);

        movieListModel = new MovieListModel("Zootopia","Animation | Action | Adventure",
                "8.2","EN","In a city of animals, a rockie bunny cop and a cynical con artist fox must work together to uncover a...",
                "","107 min","17 June 2016(USA)",R.drawable.zootopia);
        movieListModelList.add(movieListModel);

        movieListModel = new MovieListModel("Zootopia","Animation | Action | Adventure",
                "8.2","EN","In a city of animals, a rockie bunny cop and a cynical con artist fox must work together to uncover a...",
                "","107 min","17 June 2016(USA)",R.drawable.zootopia);
        movieListModelList.add(movieListModel);

        movieListAdapter.notifyDataSetChanged();
    }
}
