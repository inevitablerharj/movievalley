package com.rharj.movievalley.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rharj.movievalley.R;
import com.rharj.movievalley.model.ComingSoonModel;

import java.util.List;

public class ComingSoonAdapter extends RecyclerView.Adapter<ComingSoonAdapter.MyViewHolder> {

    List<ComingSoonModel> comingSoonModelList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView movie_image;
        public TextView movie_title,movie_category;
        public MyViewHolder(View view) {
            super(view);

            movie_image = (ImageView) view.findViewById(R.id.coming_soon_image);
            movie_title = (TextView) view.findViewById(R.id.movie_title);
            movie_category = (TextView) view.findViewById(R.id.movie_category);
        }
    }

    public ComingSoonAdapter(List<ComingSoonModel> responseList, Context context) {
        this.comingSoonModelList = responseList;
        this.context = context;
    }

    @Override
    public ComingSoonAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_coming_soon_movie_item, parent, false);

        return new ComingSoonAdapter.MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return comingSoonModelList.size();
    }

    @Override
    public void onBindViewHolder(ComingSoonAdapter.MyViewHolder holder, int position) {
        final ComingSoonModel movieListModel = comingSoonModelList.get(position);
        holder.movie_title.setText(movieListModel.getMovieName());
        holder.movie_category.setText(movieListModel.getMovieCategory());
        Glide.with(context).load(movieListModel.getMovieImage()).into(holder.movie_image);
    }
}
