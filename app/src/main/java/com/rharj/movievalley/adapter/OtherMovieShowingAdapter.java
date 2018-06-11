package com.rharj.movievalley.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rharj.movievalley.R;
import com.rharj.movievalley.model.ComingSoonModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OtherMovieShowingAdapter extends RecyclerView.Adapter<OtherMovieShowingAdapter.
        MyViewHolder> {

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

    public OtherMovieShowingAdapter(List<ComingSoonModel> responseList, Context context) {
        this.comingSoonModelList = responseList;
        this.context = context;
    }

    @Override
    public OtherMovieShowingAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_other_movie_showing, parent, false);

        return new OtherMovieShowingAdapter.MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return comingSoonModelList.size();
    }

    @Override
    public void onBindViewHolder(OtherMovieShowingAdapter.MyViewHolder holder, int position) {
        final ComingSoonModel movieListModel = comingSoonModelList.get(position);
        holder.movie_title.setText(movieListModel.getMovieName());
        holder.movie_category.setText(movieListModel.getMovieCategory());
        Picasso.with(context).load(movieListModel.getMovieImage()).into(holder.movie_image);
    }
}
