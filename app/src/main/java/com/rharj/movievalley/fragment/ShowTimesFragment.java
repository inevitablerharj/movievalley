package com.rharj.movievalley.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.rharj.movievalley.R;
import com.rharj.movievalley.adapter.ShowTimesAdapter;
import com.rharj.movievalley.model.ShowTimesModel;

import java.util.ArrayList;
import java.util.List;

public class ShowTimesFragment extends BottomSheetDialogFragment {

    RecyclerView showtimes;
    ImageView close_button;

    private ShowTimesAdapter showTimesAdapter;
    List<ShowTimesModel> showTimesModelList = new ArrayList<>();

    public static ShowTimesFragment getInstance() {
        return new ShowTimesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = prepareViews(inflater, container);
        return rootView;

    }

    private View prepareViews(LayoutInflater inflater, ViewGroup container) {
        final View mainView = inflater.inflate(R.layout.layout_movie_show_times, container,
                false);

        showtimes = (RecyclerView) mainView.findViewById(R.id.show_times);
        showTimesAdapter = new ShowTimesAdapter(showTimesModelList,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,false);
        showtimes.setLayoutManager(linearLayoutManager);
        showtimes.setItemAnimator(new DefaultItemAnimator());
        showtimes.setNestedScrollingEnabled(false);
        showtimes.setAdapter(showTimesAdapter);
        showtimes.hasFixedSize();

        prepareShowtimeData();

        close_button = (ImageView) mainView.findViewById(R.id.close_button);
        close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return mainView;
    }

    private void prepareShowtimeData() {

        ShowTimesModel showTimesModel = new ShowTimesModel("Silverbird Cinema",
                "FRI-SUN, MON-THUR: 12:50PM, 4:45PM, 9:25PM","");
        showTimesModelList.add(showTimesModel);

        showTimesModel = new ShowTimesModel("Silverbird Cinema",
                "FRI-SUN, MON-THUR: 12:50PM, 4:45PM, 9:25PM","");
        showTimesModelList.add(showTimesModel);

        showTimesModel = new ShowTimesModel("Silverbird Cinema",
                "FRI-SUN, MON-THUR: 12:50PM, 4:45PM, 9:25PM","");
        showTimesModelList.add(showTimesModel);

        showTimesModel = new ShowTimesModel("Silverbird Cinema",
                "FRI-SUN, MON-THUR: 12:50PM, 4:45PM, 9:25PM","");
        showTimesModelList.add(showTimesModel);

        showTimesAdapter.notifyDataSetChanged();
    }
}
