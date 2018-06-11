package com.rharj.movievalley.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.rharj.movievalley.R;
import com.rharj.movievalley.model.ShowTimesModel;

import java.util.List;

public class ShowTimesAdapter extends RecyclerView.Adapter<ShowTimesAdapter.MyViewHolder> {

    List<ShowTimesModel> showTimesModelList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView cinemaName,show_time;
        public ImageView overflow;
        public MyViewHolder(View view) {
            super(view);

            cinemaName = (TextView) view.findViewById(R.id.cinema_name);
            show_time = (TextView) view.findViewById(R.id.show_time);
            overflow = (ImageView) view. findViewById(R.id.get_directions);
        }
    }

    public ShowTimesAdapter(List<ShowTimesModel> responseList, Context context) {
        this.showTimesModelList = responseList;
        this.context = context;
    }

    @Override
    public ShowTimesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_showtimes_movie_item, parent, false);

        return new ShowTimesAdapter.MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return showTimesModelList.size();
    }

    @Override
    public void onBindViewHolder(final ShowTimesAdapter.MyViewHolder holder, final int position) {
        final ShowTimesModel cinemaListModel = showTimesModelList.get(position);
        holder.cinemaName.setText(cinemaListModel.getCinema_name());
        holder.show_time.setText(cinemaListModel.getShow_times());
        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popupMenu = new PopupMenu(context,holder.overflow);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(context,"You Clicked : " + position,
                                Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });

                popupMenu.show();
            }
        });
    }


}
