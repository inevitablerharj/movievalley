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
import com.rharj.movievalley.adapter.CinemaListAdapter;
import com.rharj.movievalley.model.CinemaListModel;

import java.util.ArrayList;
import java.util.List;

public class CinemaListFragment extends Fragment {

    RecyclerView cinema_list;
    CinemaListAdapter cinemaListAdapter;
    List<CinemaListModel> cinemaListModelList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = prepareViews(inflater, container);
        return rootView;

    }

    private View prepareViews(LayoutInflater inflater, ViewGroup container) {
        final View mainView = inflater.inflate(R.layout.layout_cinema_list_layoout, container,
                false);

        cinema_list = (RecyclerView) mainView.findViewById(R.id.cinema_list);
        cinemaListAdapter = new CinemaListAdapter(cinemaListModelList,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,false);
        cinema_list.setLayoutManager(linearLayoutManager);
        cinema_list.setItemAnimator(new DefaultItemAnimator());
        cinema_list.setNestedScrollingEnabled(false);
        cinema_list.setAdapter(cinemaListAdapter);
        cinema_list.hasFixedSize();

        prepareCinemaList();

        return mainView;
    }

    private void prepareCinemaList() {

        CinemaListModel cinemaListModel = new CinemaListModel("Silverbird Galleria",
                "Silverbird Galleria, 133, Ahmadu Bello way, VI, Lagos");
        cinemaListModelList.add(cinemaListModel);

        cinemaListModel = new CinemaListModel("Genesis Cinemas",
                "The Palms Shopping Mall Lekki Lagos");
        cinemaListModelList.add(cinemaListModel);

        cinemaListModel = new CinemaListModel("Filmhouse Cinema",
                "Filmhouse Leisure Mall, Adeniran Sreet, Surulere, Lagos");
        cinemaListModelList.add(cinemaListModel);

        cinemaListModel = new CinemaListModel("Ozone Galleria",
                "E-centre, 1-11 Commercial Ave, Sabo yaba, Lagos");
        cinemaListModelList.add(cinemaListModel);

        cinemaListAdapter.notifyDataSetChanged();
    }

}
