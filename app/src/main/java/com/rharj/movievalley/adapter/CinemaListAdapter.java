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
import com.rharj.movievalley.model.CinemaListModel;

import java.util.List;

public class CinemaListAdapter extends RecyclerView.Adapter<CinemaListAdapter.MyViewHolder> {

    List<CinemaListModel> cinemaListModelList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView cinemaName,cinema_address;
        public ImageView overflow;
        public MyViewHolder(View view) {
            super(view);

            cinemaName = (TextView) view.findViewById(R.id.cinemaName);
            cinema_address = (TextView) view.findViewById(R.id.cinema_address);
            overflow = (ImageView) view. findViewById(R.id.overflow);
        }
    }

    public CinemaListAdapter(List<CinemaListModel> responseList, Context context) {
        this.cinemaListModelList = responseList;
        this.context = context;
    }

    @Override
    public CinemaListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_cinema_list_view, parent, false);

        return new CinemaListAdapter.MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return cinemaListModelList.size();
    }

    @Override
    public void onBindViewHolder(final CinemaListAdapter.MyViewHolder holder, final int position) {
        final CinemaListModel cinemaListModel = cinemaListModelList.get(position);
        holder.cinemaName.setText(cinemaListModel.getCinemaName());
        holder.cinema_address.setText(cinemaListModel.getCinemaAddress());
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
